package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Trabajador;
import Modelo.TrabajadorDAO;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Controlador() {
        super();
    }

    Trabajador tr = new Trabajador();
    TrabajadorDAO tdao = new TrabajadorDAO();
    int IdEmpleado;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        
        if (menu != null) {
            switch (menu) {
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "Productos":
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                    break;
                case "Empleados":
                    switch (accion) {
                        case "Listar":
                            List lista = tdao.listar();
                            request.setAttribute("trabajadores", lista);
                            break;
                        case "Agregar":
                            String pass = request.getParameter("txtPass");
                            String name = request.getParameter("txtName");
                            String tfn = request.getParameter("txtTfn");
                            String state = request.getParameter("txtState");
                            String user = request.getParameter("txtUsuario");
                            tr.setPass(pass);
                            tr.setNombre(name);
                            tr.setTelefono(tfn);
                            tr.setEstado(state);
                            tr.setUser(user);
                            tdao.agregar(tr);
                            request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                            break;
                        case "Editar":
                            IdEmpleado = Integer.parseInt(request.getParameter("id"));
                            Trabajador t = tdao.listarId(IdEmpleado);
                            request.setAttribute("empleado", t);
                            request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                            break;
                        case "Delete":
                            IdEmpleado = Integer.parseInt(request.getParameter("id"));
                            tdao.delete(IdEmpleado);
                            request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                            break;
                        case "Actualizar":
                            String pass1 = request.getParameter("txtPass");
                            String name1 = request.getParameter("txtName");
                            String tfn1 = request.getParameter("txtTfn");
                            String state1 = request.getParameter("txtState");
                            String user1 = request.getParameter("txtUsuario");
                            tr.setPass(pass1);
                            tr.setNombre(name1);
                            tr.setTelefono(tfn1);
                            tr.setEstado(state1);
                            tr.setUser(user1);
                            tr.setId(IdEmpleado);
                            tdao.actualizar(tr);
                            request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
                        	break;
                        default:
                            throw new AssertionError();
                    }
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                    break;
                case "Clientes":
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "RegistrarVenta":
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
