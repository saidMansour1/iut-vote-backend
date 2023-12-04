/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cm.iutgi.iutVote.controller;

import cm.iutgi.iutVote.ejb.AdminManager;
import cm.iutgi.iutVote.ejb.ClasseManager;
import cm.iutgi.iutVote.ejb.EtudiantManager;
import cm.iutgi.iutVote.entities.Admin;
import cm.iutgi.iutVote.entities.Classe;
import cm.iutgi.iutVote.entities.Etudiant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author saims
 */
@WebServlet(name = "ApiConnect", urlPatterns = {"/ApiConnect"})
public class ApiConnect extends HttpServlet {
    //injection des entities manager
    @EJB 
    EtudiantManager etudiantManager;
    
    @EJB
    AdminManager adminManager;
    
    @EJB
    ClasseManager classeManager;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("action") != null){
                    
            System.out.println("action is ok");
            JSONArray jsonArray = new JSONArray();
            JSONObject resultJO = new JSONObject();
            JSONObject userInfoJO = new JSONObject();
            String result = "NOK";
            
            //partie concernant la connexion
            if (request.getParameter("action").equals("login") 
                    && request.getParameter("id") != null 
                    && request.getParameter("mdp") != null
                    && request.getParameter("admin") != null)
            {
                    
                System.out.println("action is login");
                //connexion d'un admin
                if(request.getParameter("admin").equals("oui")) {
                    
                    System.out.println("admin ok");
                    Admin admin;
                    String id = request.getParameter("id"), mdp = request.getParameter("mdp");

                    admin = adminManager.findAdmin(id, mdp);

                    if(admin != null){
                        result = "OK";

                        userInfoJO.put("nom", admin.getNom());
                        userInfoJO.put("pseudo", admin.getPseudo());
                        userInfoJO.put("telephone", admin.getNumeroTel());
                        userInfoJO.put("mail", admin.getMail());


                    }else{
                        result = "NOK";

                    }
                    
                }
                //connexion d'un étudiant
                else if(request.getParameter("admin").equals("non")){
                    
                    System.out.println("admin is nonok");
                    Etudiant etudiant;
                    String id = request.getParameter("id"), mdp = request.getParameter("mdp");

                    etudiant = etudiantManager.findEtudiant(id, mdp);

                    if(etudiant != null){
                        result = "OK";

                        userInfoJO.put("matricule", etudiant.getMatricule());
                        userInfoJO.put("nom", etudiant.getNom());
                        userInfoJO.put("pseudo", etudiant.getPseudo());
                        userInfoJO.put("telephone", etudiant.getNumeroTel());
                        userInfoJO.put("mail", etudiant.getMail());


                    }else{
                        result = "NOK";

                    }
                    
                }
            }
            
            
            //partie concernant l'inscription
            if (request.getParameter("action").equals("signup") 
                    && request.getParameter("id") != null
                    && request.getParameter("mdp") != null 
                    && request.getParameter("nom") != null 
                    && request.getParameter("pseudo") != null 
                    && request.getParameter("telephone") != null 
                    && request.getParameter("admin") != null 
            ){
                //inscription d'un admin
                if(request.getParameter("admin").equals("oui")) {
                    Admin admin = adminManager.findByMail(request.getParameter("id"));
                    if(admin == null){
                        admin = new Admin();
                        
                        admin.setNom(request.getParameter("nom"));
                        admin.setPseudo(request.getParameter("pseudo"));
                        admin.setNumeroTel(request.getParameter("telephone"));
                        admin.setMail(request.getParameter("id"));
                        admin.setMotDePasse(request.getParameter("mdp"));
                        
                        adminManager.persist(admin);
                        result = "OK";

                        userInfoJO.put("nom", admin.getNom());
                        userInfoJO.put("pseudo", admin.getPseudo());
                        userInfoJO.put("telephone", admin.getNumeroTel());
                        userInfoJO.put("mail", admin.getMail());
                    }else
                        result = "NOK";
                }
                //inscription d'un étudiant
                else if(request.getParameter("admin").equals("non") && request.getParameter("classe") != null) {
                    Etudiant etudiant = etudiantManager.findByMatricule(request.getParameter("id"));
                    Classe classe = classeManager.findByName(request.getParameter("classe"));
                    System.out.println(classe);
                    if(etudiant == null && classe != null){
                        System.out.println("etudiant == null && classe != null"); 
                        etudiant = new Etudiant();
                        
                        
                        etudiant.setMatricule(request.getParameter("id"));
                        etudiant.setNom(request.getParameter("nom"));
                        etudiant.setIdClasse(classe);
                        etudiant.setPseudo(request.getParameter("pseudo"));
                        etudiant.setNumeroTel(request.getParameter("telephone"));
                        etudiant.setMotDePasse(request.getParameter("mdp"));
                        
                        etudiantManager.persist(etudiant);
                        result = "OK";

                        userInfoJO.put("matricule", etudiant.getMatricule());
                        userInfoJO.put("nom", etudiant.getNom());
                        userInfoJO.put("pseudo", etudiant.getPseudo());
                        userInfoJO.put("telephone", etudiant.getNumeroTel());
                        userInfoJO.put("mail", etudiant.getMail());
                    }else
                        result = "NOK";
                }
            } 
                
                

            resultJO.put("response", result);
            jsonArray.add(resultJO);
            jsonArray.add(userInfoJO);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
            
            response.getWriter().print(jsonArray);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("\n\n\n get");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("\n\n\n post");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
