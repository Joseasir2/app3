<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
<title>Taller</title>
</head>
<body>
    <div class="d-flex">
       <div class="card col-sm-4">
	   <div class="card-body">
	      <form action="Controlador?menu=Empleados" method="POST">
	         <div class="form-group">
	            <label>Password</label>
	            <input type="text" value="${empleado.getPass()}" name="txtPass" class="form-control">
	         </div>
	         <div class="form-group">
	            <label>Nombre</label>
	            <input type="text" name="txtName" value="${empleado.getNombre()}" class="form-control">
	         </div>
	         <div class="form-group">
	            <label>Télefono</label>
	            <input type="text" name="txtTfn" value="${empleado.getTelefono()}" class="form-control">
	         </div>
	         <div class="form-group">
	            <label>Estado</label>
	            <input type="text" name="txtState" value="${empleado.getEstado()}" class="form-control">
	         </div>
	         <div class="form-group">
	            <label>Usuario</label>
	            <input type="text" name="txtUsuario" value="${empleado.getUser()}" class="form-control">
	         </div>
	         <input type="submit" name="accion" value="Agregar" class="btn btn-info">
	         <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
	      </form>
	   </div>
	</div>
	<div class="col-sm-8">
	   <table class="table table-hover">
	      <thead>
	         <tr>
	            <th>ID</th>
	            <th>PASSWORD</th>
	            <th>NOMBRE</th>
	            <th>TELEFONO</th>
	            <th>ESTADO</th>
	            <th>USUARIO</th>
	            <th>ACCION</th>
	         </tr>
	      </thead>
	      <tbody>
	         <c:forEach var="trabajador" items="${trabajadores}">
	         <tr>
	            <td>${trabajador.getId()}</td>
	            <td>${trabajador.getPass()}</td>
	            <td>${trabajador.getNombre()}</td>
	            <td>${trabajador.getTelefono()}</td>
	            <td>${trabajador.getEstado()}</td>
	            <td>${trabajador.getUser()}</td>
	            <td>
	               <a class="btn btn-warning" href="Controlador?menu=Empleados&accion=Editar&id=${trabajador.getId()}">Editar</a>
	               <a class="btn btn-danger" href="Controlador?menu=Empleados&accion=Delete&id=${trabajador.getId()}">Delete</a>
	            </td>
	         </tr>
	         </c:forEach>
	      </tbody>
	   </table>
	</div>
    </div>
	
</body>
<!-- Scripts necesarios para Bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</html>