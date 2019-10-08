package Servlet;

import Control.GestorPrincipal;
import Modelo.Producto;
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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "ServletProductos", urlPatterns = {"/ServletProductos"})
public class ServletProductos extends HttpServlet {

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
        String region = request.getParameter("category");
        ArrayList productos = ges.getProductos(region);
        Iterator it=productos.iterator();
        int contador=0;
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>\n" +
"<head>\n" +
"    <title>NatAmE</title>\n" +
"    <meta charset=\"utf-8\" />\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
"    <link rel=\"stylesheet\" href=\"assets/css/mainCompra.css\" />\n" +
"\n" +
"    <script>\n" +
"        window.onload = function () {\n" +
"            // Variables\n" +
"            let baseDeDatos = [");
            while (it.hasNext()){
                Producto prod=(Producto)it.next();
                if (contador!=0) out.println(",");
                out.println("{\n" +
"                id: "+ prod.getCodigo()+",\n" +
"                nombre: '"+prod.getNombre()+"',\n" +
"                precio: "+prod.getPrecio()+"\n" +
"            }");
                contador++;
            }
            
            out.println("]\n" +
"            let $items = document.querySelector('#items');\n" +
"            let carrito = [];\n" +
"            let total = 0;\n" +
"            let $carrito = document.querySelector('#carrito');\n" +
"            let $total = document.querySelector('#total');\n" +
"            // Funciones\n" +
"            function renderItems () {\n" +
"                for (let info of baseDeDatos) {\n" +
"                    // Estructura\n" +
"                    let miNodo = document.createElement('div');\n" +
"                    miNodo.classList.add('card', 'col-sm-4');\n" +
"                    // Body\n" +
"                    let miNodoCardBody = document.createElement('div');\n" +
"                    miNodoCardBody.classList.add('card-body');\n" +
"                    // Titulo\n" +
"                    let miNodoTitle = document.createElement('h5');\n" +
"                    miNodoTitle.classList.add('card-title');\n" +
"                    miNodoTitle.textContent = info['nombre'];\n" +
"                    // Precio\n" +
"                    let miNodoPrecio = document.createElement('p');\n" +
"                    miNodoPrecio.classList.add('card-text');\n" +
"                    miNodoPrecio.textContent = '$'+info['precio'] ;\n" +
"                    // Boton \n" +
"                    let miNodoBoton = document.createElement('button');\n" +
"                    miNodoBoton.classList.add('carritoMas');\n" +
"                    miNodoBoton.textContent = '+';\n" +
"                    miNodoBoton.setAttribute('marcador', info['id']);\n" +
"                    miNodoBoton.addEventListener('click', anyadirCarrito);\n" +
"                    // Insertamos\n" +
"                    miNodoCardBody.appendChild(miNodoTitle);\n" +
"                    miNodoCardBody.appendChild(miNodoPrecio);\n" +
"                    miNodoCardBody.appendChild(miNodoBoton);\n" +
"                    miNodo.appendChild(miNodoCardBody);\n" +
"                    $items.appendChild(miNodo);\n" +
"                }\n" +
"            }\n" +
"            function anyadirCarrito () {\n" +
"                // Anyadimos el Nodo a nuestro carrito\n" +
"                carrito.push(this.getAttribute('marcador'))\n" +
"                // Calculo el total\n" +
"                calcularTotal();\n" +
"                // Renderizamos el carrito \n" +
"                renderizarCarrito();\n" +
"\n" +
"            }\n" +
"\n" +
"            function renderizarCarrito () {\n" +
"                // Vaciamos todo el html\n" +
"                $carrito.textContent = '';\n" +
"                // Generamos los Nodos a partir de carrito\n" +
"                carrito.forEach(function (item, indice) {\n" +
"                    // Obtenemos el item que necesitamos de la variable base de datos\n" +
"                    let miItem = baseDeDatos.filter(function(itemBaseDatos) {\n" +
"                        return itemBaseDatos['id'] == item;\n" +
"                    });\n" +
"                    // Creamos el nodo del item del carrito\n" +
"                    let miNodo = document.createElement('li');\n" +
"                    miNodo.classList.add('list-group-item', 'text-right');\n" +
"                    miNodo.textContent = `${miItem[0]['nombre']} - $${miItem[0]['precio']}   `;\n" +
"                    // Boton de borrar\n" +
"                    let miBoton = document.createElement('button');\n" +
"                    miBoton.classList.add('btn', 'carritoX');\n" +
"                    miBoton.textContent = 'X';\n" +
"                    miBoton.setAttribute('posicion', indice);\n" +
"                    miBoton.addEventListener('click', borrarItemCarrito);\n" +
"\n" +
"                    // Mezclamos nodos\n" +
"                    miNodo.appendChild(miBoton);\n" +
"                    $carrito.appendChild(miNodo);\n" +
"                })\n" +
"            }\n" +
"\n" +
"            function borrarItemCarrito () {\n" +
"                // Obtenemos la posicion que hay en el boton pulsado\n" +
"                let posicion = this.getAttribute('posicion');\n" +
"                // Borramos la posicion que nos interesa\n" +
"                carrito.splice(posicion, 1);\n" +
"                // volvemos a renderizar\n" +
"                renderizarCarrito();\n" +
"                // Calculamos de nuevo el precio\n" +
"                calcularTotal();\n" +
"            }\n" +
"\n" +
"            function calcularTotal () {\n" +
"                // Limpiamos precio anterior\n" +
"                total = 0;\n" +
"                // Recorremos el array del carrito\n" +
"                for (let item of carrito) {\n" +
"                    // De cada elemento obtenemos su precio\n" +
"                    let miItem = baseDeDatos.filter(function(itemBaseDatos) {\n" +
"                        return itemBaseDatos['id'] == item;\n" +
"                    });\n" +
"                    total = total + miItem[0]['precio'];\n" +
"                }\n" +
"                // Formateamos el total para que solo tenga dos decimales\n" +
"                let totalDosDecimales = total.toFixed(2);\n" +
"                // Renderizamos el precio en el HTML\n" +
"                $total.textContent = totalDosDecimales;\n" +
"            }\n" +
"            // Eventos\n" +
"\n" +
"            // Inicio\n" +
"            renderItems();\n" +
"        } \n" +
"    </script>\n" +
"</head>\n" +
"<!-- Header -->\n" +
"<header id=\"header\" class=\"skel-layers-fixed\">\n" +
"    <h1><a href=\"index.html\">NatAme</a></h1>\n" +
"    <a href=\"#nav\">Menu</a>\n" +
"</header>\n" +
"\n" +
"<!-- Nav -->\n" +
"<nav id=\"nav\">\n" +
"    <ul class=\"links\">\n" +
"        <li><a href=\"principal.html\">Inicio</a></li>\n" +
"\n" +
"    </ul>\n" +
"</nav>\n" +
"\n" +
"<!-- Main -->\n" +
"<section id=\"main\" class=\"wrapper\">\n" +
"    <div class=\"container\">\n" +
"        <header class=\"major special\">\n" +
"            <h2>PRODUCTOS</h2>\n" +
"            <p>Agregue al carro de compra, los productos que desee comprar.</p>\n" +
"        </header>\n" +
"        \n" +
"        <div class=\"row uniform 50%\">\n" +
"            <!-- Elementos generados a partir del JSON -->\n" +
"            <div class=\"6u 12u$(xsmall)\">\n" +
"                <main id=\"items\" class=\"col-sm-4 row\"></main>\n" +
"            </div>\n" +
"            <!-- Carrito -->\n" +
"            <div class=\"6u 12u$(xsmall)\"> \n" +
"                <form method=\"post\" action=\"#\">\n" +
"                    <h3>CARRO DE COMPRAS</h3>\n" +
"                    <!-- Elementos del carrito -->\n" +
"\n" +
"                    <ul id=\"carrito\" class=\"list-group\"></ul>\n" +
"                    <hr>\n" +
"                    <!-- Precio total -->\n" +
"                    <p >Total: &dollar;<span id=\"total\"></span></p>\n" +
"                    <ul class=\"actions\">\n" +
"                        <li><input type=\"submit\" value=\"Comprar\" class=\"special\" /></li>\n" +
"\n" +
"                    </ul>\n" +
"                </div>\n" +
"            </div>\n" +
"            \n" +
"        </form>\n" +
"    </div>\n" +
"</section>\n" +
"<!-- Footer -->\n" +
"<footer id=\"footer\">\n" +
"    <div class=\"inner\">\n" +
"        <ul class=\"copyright\">\n" +
"            <li>&copy; Universidad Distrital.</li>\n" +
"            <li>Images: <a href=\"http://unsplash.com\">Unsplash</a>.</li>\n" +
"            <li>Design: <a href=\"http://templated.co\">TEMPLATED</a>.</li>\n" +
"        </ul>\n" +
"    </div>\n" +
"</footer>\n" +
"\n" +
"<!-- Scripts -->\n" +
"<script src=\"assets/js/jquery.min.js\"></script>\n" +
"<script src=\"assets/js/skel.min.js\"></script>\n" +
"<script src=\"assets/js/util.js\"></script>\n" +
"<script src=\"assets/js/main.js\"></script> \n" +
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
