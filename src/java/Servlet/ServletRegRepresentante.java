/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.GestorPrincipal;
import Modelo.Region;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "ServletRegRepresentante", urlPatterns = {"/ServletRegRepresentante"})
public class ServletRegRepresentante extends HttpServlet {

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
        ArrayList regionales=ges.getRegionales();
        Iterator it = regionales.iterator();
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n" +
"<head>\n" +
"	<title>NatAmE</title>\n" +
"	<meta charset=\"utf-8\" />\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
"	<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"	<!-- Header -->\n" +
"	<header id=\"header\" class=\"skel-layers-fixed\">\n" +
"		<h1><a href=\"index.html\">NatAme</a></h1>\n" +
"		<a href=\"#nav\">Menu</a>\n" +
"	</header>\n" +
"\n" +
"	<!-- Nav -->\n" +
"	<nav id=\"nav\">\n" +
"		<ul class=\"links\">\n" +
"			<li><a href=\"principal.html\">Inicio</a></li>\n" +
"			\n" +
"		</ul>\n" +
"	</nav>\n" +
"\n" +
"	<!-- Main -->\n" +
"	<section id=\"main\" class=\"wrapper\">\n" +
"		<div class=\"container\">\n" +
"			<header class=\"major special\">\n" +
"				<h2>REGISTRAR REPRESENTANTE</h2>\n" +
"				<p>Registre un nuevo representante en el sistema, solo para representantes \"master\"</p>\n" +
"			</header>\n" +
"			<!-- Form -->\n" +
"			<section>\n" +
"				<h3>Nuevo representante</h3>\n" +
"				<form method=\"post\" action=\"ServletRegCliente\">\n" +
"					<div class=\"row uniform 50%\">\n" +
"                                                <div class=\"6u 12u(xsmall)\">\n" +
"                                                    <div class=\"select-wrapper\">\n" +
"                                                    	<select name=\"tipo_doc\" id=\"tipo_doc\">\n" +
"                                                            <option value=\"\">- Tipo de documento -</option>\n" +
"                                                            <option value=\"CC\">Cedula de cuidadania</option>\n" +
"                                                            <option value=\"CE\">Cedula extranjero</option>\n" +
"                                                            <option value=\"TI\">Tarjeta de identidad</option>\n" +
"							</select>\n" +
"                                                    </div>\n" +
"						</div>\n" +
"                                                <div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"text\" name=\"identificacion\" id=\"identificacion\" value=\"\" placeholder=\"Nro. Identificacion\" />\n" +
"						</div>\n" +
"						<div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"text\" name=\"nombre\" id=\"nombre\" value=\"\" placeholder=\"Nombres\" />\n" +
"						</div>\n" +
"						<div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"text\" name=\"apellido\" id=\"apellido\" value=\"\" placeholder=\"Apellidos\" />\n" +
"						</div><div class=\"6u 12u(xsmall)\">\n" +
"                                                    <div class=\"select-wrapper\">\n" +
"                                                    	<select name=\"tipo_doc\" id=\"tipo_doc\">\n" +
"                                                            <option value=\"\">- Region -</option>");
            while (it.hasNext()){
                Region reg=(Region) it.next();
                out.println("<option value=\""+reg.getCodigo()+"\">"+reg.getNombre()+"</option>");
            }
            out.println("</select>\n" +
"                                                    </div>\n" +
"						</div><div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"text\" name=\"email\" id=\"email\" value=\"\" placeholder=\"Cuenta de usuario\" />\n" +
"						</div>\n" +
"                                                <div class=\"6u 12u(xsmall)\">\n" +
"                                                    <div class=\"select-wrapper\">\n" +
"                                                    	<select name=\"genero\" id=\"genero\">\n" +
"                                                            <option value=\"\">- Genero -</option>\n" +
"                                                            <option value=\"M\">Masculino</option>\n" +
"                                                            <option value=\"F\">Femenino</option>\n" +
"                                                        </select>\n" +
"                                                    </div>\n" +
"						</div>\n" +
"                                                <div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"text\" name=\"f_nacimiento\" id=\"f_nacimiento\" value=\"\" placeholder=\"Fecha nacimiento dd/mm/aa\" />\n" +
"						</div>\n" +
"						<div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"text\" name=\"telefono\" id=\"telefono\" value=\"\" placeholder=\"Telefono\" />\n" +
"						</div>\n" +
"						<div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"text\" name=\"direccion\" id=\"direccion\" value=\"\" placeholder=\"Direccion\" />\n" +
"						</div>\n" +
"						<div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"password\" name=\"clave1\" id=\"clave1\" value=\"\" placeholder=\"Clave\" />\n" +
"						</div>\n" +
"                                                <div class=\"6u 12u(xsmall)\">\n" +
"							<input type=\"password\" name=\"clave2\" id=\"clave2\" value=\"\" placeholder=\"Confirmar clave\" />\n" +
"						</div>\n" +
"												\n" +
"						<div class=\"12u\">\n" +
"							<ul class=\"actions\">\n" +
"								<li><input type=\"submit\" value=\"Registrar\" class=\"special\" /></li>\n" +
"								<li><input type=\"reset\" value=\"Limpiar\" /></li>\n" +
"							</ul>\n" +
"						</div>\n" +
"					</div>\n" +
"				</form>\n" +
"			</section>	\n" +
"		</div>\n" +
"	</section>\n" +
"	<!-- Footer -->\n" +
"	<footer id=\"footer\">\n" +
"		<div class=\"inner\">\n" +
"			<ul class=\"copyright\">\n" +
"				<li>&copy; Universidad Distrital.</li>\n" +
"				<li>Images: <a href=\"http://unsplash.com\">Unsplash</a>.</li>\n" +
"				<li>Design: <a href=\"http://templated.co\">TEMPLATED</a>.</li>\n" +
"			</ul>\n" +
"		</div>\n" +
"	</footer>\n" +
"\n" +
"	<!-- Scripts -->\n" +
"	<script src=\"assets/js/jquery.min.js\"></script>\n" +
"	<script src=\"assets/js/skel.min.js\"></script>\n" +
"	<script src=\"assets/js/util.js\"></script>\n" +
"	<script src=\"assets/js/main.js\"></script>\n" +
"\n" +
"</body>\n" +
"</html>");
            
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
