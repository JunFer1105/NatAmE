/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.GestorPrincipal;
import Modelo.Cliente;
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
@WebServlet(name = "ServletPreCompra", urlPatterns = {"/ServletPreCompra"})
public class ServletPreCompra extends HttpServlet {

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
        ArrayList clientes=ges.getClientes();
        Iterator itClientes = clientes.iterator();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE HTML>\n" +
"<!--\n" +
"	Retrospect by TEMPLATED\n" +
"	templated.co @templatedco\n" +
"	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)\n" +
"-->\n" +
"<html>\n" +
"<head>\n" +
"	<title>Comprar</title>\n" +
"	<meta charset=\"utf-8\" />\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
"	<!--[if lte IE 8]><script src=\"assets/js/ie/html5shiv.js\"></script><![endif]-->\n" +
"	<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n" +
"	<!--[if lte IE 8]><link rel=\"stylesheet\" href=\"assets/css/ie8.css\" /><![endif]-->\n" +
"	<!--[if lte IE 9]><link rel=\"stylesheet\" href=\"assets/css/ie9.css\" /><![endif]-->\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"	<!-- Header -->\n" +
"	<header id=\"header\" class=\"skel-layers-fixed\">\n" +
"		<h1><a href=\"principal.html\">NATAME</a></h1>\n" +
"		<a href=\"#nav\">Menu</a>\n" +
"	</header>\n" +
"\n" +
"	<!-- Nav -->\n" +
"	<nav id=\"nav\">\n" +
"		<ul class=\"links\">\n" +
"			<li><a href=\"principal.html\">Menu Principal</a></li>\n" +
"			<li><a href=\"RegCliente.html\">Registrar Cliente</a></li>\n" +
"			<form method=\"post\" action=\"ServletProductos\">\n" +
"				<li><input type=\"submit\" value=\"Cerrar Sesion\" class=\"special\" /></li>\n" +
"			</form>\n" +
"		</ul>\n" +
"	</nav>\n" +
"\n" +
"	<!-- Main -->\n" +
"	<section id=\"main\" class=\"wrapper\">\n" +
"		<div class=\"container\">\n" +
"			<header class=\"major special\">\n" +
"				<h2>COMPRAR</h2>\n" +
"				<p>Selecciona una regional de nuestra tienda para realizar el pedido</p>\n" +
"			</header>\n" +
"			<section>\n" +
"				<h3>Seleccione</h3>\n" +
"				<form method=\"post\" action=\"ServletProductos\">\n" +
"					<div class=\"row uniform 50%\">\n" +
"						<div class=\"12u$\">\n" +
"							<div class=\"select-wrapper\">\n" +
"								<select name=\"category\" id=\"category\">\n" +
"									<option value=\"\">- Regional -</option>");
            while (it.hasNext()){
                Region reg=(Region) it.next();
                out.println("<option value=\""+reg.getNombre()+"\">"+reg.getNombre()+"</option>");
            }
            
            
            out.println("</select>\n" +
"							</div>\n" +
"						</div>\n" +
"						<div class=\"12u$\">\n" +
"							<div class=\"select-wrapper\">\n" +
"								<select name=\"category\" id=\"category\">\n" +
"									<option value=\"\">- Cliente -</option>");
            while (itClientes.hasNext()){
                Cliente cli=(Cliente) itClientes.next();
                out.println("<option value=\""+cli.getIdentificacion()+"\">"+cli.getNombre()+" "+cli.getApellido()+"</option>");
            }
            
            out.println("</select>\n" +
"							</div>\n" +
"						</div>\n");
            
            out.println("<div class=\"12u$\">\n" +
"							<ul class=\"actions\">\n" +
"								<li><input type=\"submit\" value=\"Buscar\" class=\"special\" /></li>\n" +
"								<li><input type=\"reset\" value=\"Borrar\" /></li>\n" +
"							</ul>\n" +
"						</div>\n" +
"					</div>\n" +
"				</form>\n" +
"			</section>\n" +
"		</div>\n" +
"	</section>\n" +
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
"	<!--[if lte IE 8]><script src=\"assets/js/ie/respond.min.js\"></script><![endif]-->\n" +
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
