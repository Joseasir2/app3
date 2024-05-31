<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
<title>Taller</title>
</head>
<body>
    <div class="container mt-4 col-lg-4">
        <div class="card col-sm-10">
            <div class="card-body">
                <form class="form-sign" action="Validar" method="POST">
                    <div class="form-group text-center">
                        <h3>Bienvenido al sistema</h3>
                        <img src="img/logo.jpg" alt="150" width="150"/>
                    </div>
                    <div class="form-group">
                        <label>Usuario:</label>
                        <input type="text" name="user" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Contraseña:</label>
                        <input type="password" name="pass" class="form-control">
                    </div>
                    <input type="hidden" name="accion" value="login">
                    <input type="submit" class="btn btn-primary btn-block" value="Iniciar sesión">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
