/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.GestorPrincipal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author elric
 */
@WebServlet(name = "ServletRegistroRepresentante", urlPatterns = {"/ServletRegistroRepresentante"})
public class ServletRegistroRepresentante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        GestorPrincipal ges=(GestorPrincipal)session.getAttribute("Gestor");
        String clave1=request.getParameter("clave1");
        String clave2=request.getParameter("clave2");
        if (!clave1.equals(clave2)){
            response.sendRedirect("RegRepresentante.html");
        }
        String f_nacimiento=request.getParameter("f_nacimiento");
        String cod_region=request.getParameter("cod_region");
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String telefono=request.getParameter("telefono");
        String email=request.getParameter("email");
        String direccion=request.getParameter("direccion");
        String identificacion=request.getParameter("identificacion");
        String tipo_doc=request.getParameter("tipo_doc");
        String genero=request.getParameter("genero");
        
        String resultado=ges.regRepresentante(identificacion, tipo_doc,nombre, apellido,cod_region,email,genero, f_nacimiento, telefono, direccion, clave2);
        if(resultado.equals("funciono")){
            response.sendRedirect("principal.html");
        }else{
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>\n" +
"		<title>Error NatAmE</title>\n" +
"		<meta charset=\"utf-8\" />\n" +
"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
"		<!--[if lte IE 8]><script src=\"assets/js/ie/html5shiv.js\"></script><![endif]-->\n" +
"		<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n" +
"		<!--[if lte IE 8]><link rel=\"stylesheet\" href=\"assets/css/ie8.css\" /><![endif]-->\n" +
"		<!--[if lte IE 9]><link rel=\"stylesheet\" href=\"assets/css/ie9.css\" /><![endif]-->\n" +
"	</head>");
            
            out.println("<body>");
            out.println("<!-- Header -->\n" +
"	<header id=\"header\" class=\"skel-layers-fixed\">\n" +
"		<h1><a href=\"index.html\">NatAme</a></h1>\n" +
"	</header>");
            out.println("<h2>Ha ocurrido un error</h2>");
            out.println("<p>El motor de base de datos ORACLE dice: <strong>" + resultado + "</strong></p>");
            out.println("<ul class=\"actions\">\n" +
"		<li><a href=\"principal.html\" class=\"button alt small\">Regresar</a></li>\n" +
"		</ul>");
            
            out.println("</body>");
            out.println("</html>");
        }
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
