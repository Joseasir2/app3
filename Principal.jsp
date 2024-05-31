<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
<title>Taller</title>
<style>
    .dropdown button {
        width: auto; /* Auto-adjust width to fit the content */
        white-space: nowrap; /* Prevent text from wrapping */
    }
    .dropdown-menu {
        left: auto;
        right: 0; /* Align dropdown to the right */
    }
</style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a style="margin-left: 10px; border: none"
                    class="btn btn-outline-light" href="#">Home</a></li>
                <li class="nav-item"><a style="margin-left: 10px; border: none"
                    class="btn btn-outline-light" href="Controlador?menu=Productos" target="myFrame">Productos</a></li>
                <li class="nav-item"><a style="margin-left: 10px; border: none"
                    class="btn btn-outline-light" href="Controlador?menu=Empleados&accion=Listar" target="myFrame">Empleado</a></li>
                <li class="nav-item"><a style="margin-left: 10px; border: none"
                    class="btn btn-outline-light" href="Controlador?menu=Clientes" target="myFrame">Clientes</a></li>
                <li class="nav-item"><a style="margin-left: 10px; border: none"
                    class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta" target="myFrame">Nueva Venta</a></li>
            </ul>
        </div>
        <div class="dropdown ml-auto" style="margin-right: 35px">
            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button"
                data-toggle="dropdown" aria-expanded="false" id="dropdownMenu">${user.getNombre()}</button>
            <div class="dropdown-menu dropdown-menu-right text-center" aria-labelledby="dropdownMenu">
                <a class="dropdown-item" href="#">
                   <img src="img/user.png" alt="user" width="50px"/>
                </a> 
                <a class="dropdown-item" href="#">${user.getUser()}</a> 
                <a class="dropdown-item" href="#">${user.getUser()}@gmail.com</a>
                <div class="dropdown-divider"></div>
                <form action="Validar" method="POST">
                    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                </form>
            </div>
        </div>
    </nav>
    <div class="m-4" style="height: 550px;">
      <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
    </div>

    <!-- Scripts necesarios para Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
