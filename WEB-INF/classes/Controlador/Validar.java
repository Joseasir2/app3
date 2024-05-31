package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Trabajador;
import Modelo.TrabajadorDAO;

@WebServlet("/Validar")
public class Validar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrabajadorDAO tdao = new TrabajadorDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null && accion.equalsIgnoreCase("login")) {
            String user = request.getParameter("user");
            String password = request.getParameter("pass");
            System.out.println("Usuario: " + user);
            System.out.println("Contraseña: " + password);

            Trabajador trabajador = tdao.validar(user, password);

            if (trabajador != null && trabajador.getUser() != null) {
                System.out.println("Inicio de sesión exitoso");
                request.setAttribute("user", trabajador);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {
                System.out.println("Inicio de sesión fallido");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
