<%-- 
    Document   : editarProducto
    Created on : 7/12/2019, 12:08:06 AM
    Author     : fernandourg
--%>
<%@page import="java.util.List"%>
<%@page import="Models.producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    producto listpro;
    String nUsuario="";
    String isAdmin="";            
    listpro = (producto) request.getAttribute("productoSh");
    int idCat= 0;
    int uni=0;
    int idpr = 0;
    uni = listpro.getUnidades();
    idpr = listpro.getIdproducto();
    idCat = listpro.getIdCategoria();
    boolean estado=false;
                    
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="height=device-height, width=device-width, initial-scale=1.0, maximum-scale=5.0, minimum-scale=1.0, viewport-fit=cover">
	<title>Registrarse</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/b26f182c55.js" crossorigin="anonymous"></script>
        <script>
	$(document).ready(function(){
            //alert("todo cargado");
           
                               
            
           
        });	
	
	</script>
	
</head>
<body>
	<!-- nav bar -->
	
		<nav class="navbar navbar-expand-lg navbar-dark">
			 <a class="navbar-brand" href="dashboard">Inicio</a>
                         <%   if(session.getAttribute("usuario")!= null){
                                isAdmin=(String)session.getAttribute("usuario");
                                if(isAdmin.equals("Administrador")){
                        %>
                          <a class="navbar-brand" href="productoVenta.jsp">Vender</a>
                          <a class="navbar-brand" href="productoManejo">Productos</a>
                        <%
                              }
                                }
                        %>
			 <div class="dropdown show">
					<a class="nav-brand dropdown-toggle" data-toggle="dropdown" id="dropdown_target" aria-haspopup="true" aria-expanded="false" href="#">Categorias
					   <span class="caret"></span>
				   </a>
				   <div class="dropdown-menu" aria-labelledby="dropdown_target">
					   
					   <a class="dropdown-item" href="catSearch?idcat=1">Smartphones</a>
					   <div class="dropdown-divider"></div>
					   <a class="dropdown-item" href="catSearch?idcat=3">Electronicos</a>
					   <div class="dropdown-divider"></div>
					   <a class="dropdown-item" href="catSearch?idcat=2">Hogar</a>
					   <div class="dropdown-divider"></div>
					   <a class="dropdown-item" href="catSearch?idcat=4">Juguetes</a>
				   </div>
				  </div>
			 		
			 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			 	<span class="navbar-toggler-icon"></span>
			 </button>
			 <div class="collapse navbar-collapse" id="navbarResponsive">
			 	<ul class="navbar-nav ml-auto">
			 		<%
                                        if(null == session.getAttribute("usuario")){
                                    %>
			 		<li class="nav-item">
						 <a class="navbar-brand" href="#" data-toggle="modal" data-target="#modalLogIn">Iniciar Sesion</a>
						 	<span class="sr-only">(current)</span>
					</li>
                                    <%
                                           }else{
                                           
                                           nUsuario=(String)session.getAttribute("usuario");
                                           
                                    %>  
                                        <li class="nav-item">
                                        <img src="getUserImage?userName=<%= nUsuario%>" width="30px" height="30px" class="card-img-top" alt="...">
                                        </li>
                                        <li class="nav-item">
                                                     <a class="navbar-brand" href="#" ><%=nUsuario%></a>
                                                            <span class="sr-only">(current)</span>
                                        </li>
                                        
                                            
                                        
                                    <%
                                        }
                                    %>
                                    <%
                                        if(session.getAttribute("usuario")!= null){
                                    %>
					<li class="nav-item">
						 <a class="navbar-brand" href="logOut">LogOut</a>
					</li>
                                     <%
                                        }else if(session.getAttribute("usuario")== null){
                                    %>
                                         <li class="nav-item">
						 <a class="navbar-brand" href="registro.jsp">Registrarse</a>
					</li>
                                    <%
                                        }
                                    %>
				</ul>
			<!-- Search form -->
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
				<a href="advanced-search.html" class="btn btn-light my-smn-0" type="submit"><i class="fas fa-search"></i></a>
				
			</form>

			</div>
		</nav>
	

	<!-- fin navbar -->
        
    <!-- Registro -->
    
    <div class="container" id="registro">

            <h2>Editar Producto</h2>
        
            <form action="editarProducto2" method="POST" class="register-form" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="nombre">Nombre Producto</label>
                        <input name="nombre" class="form-control" type="text" value="<%= listpro.getNombre()%>" required>
                        
                    </div>            
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="descripcion1">Descripcion</label>
                        <input name="descripcion" class="form-control" type="text" maxlength="300"  value="<%= listpro.getDescripcion()%>" required>             
                    </div>            
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="unidades">Unidades</label>
                        <input name="unidades" class="form-control" type="number" value="<%= uni%>" required>             
                    </div>            
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="imagen1">Imagen 1</label>
                        <input name="imagen1" class="form-control-file" type="file"value="<%= listpro.getImagen()%>" required>             
                    </div>
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="imagen2">Imagen 2</label>
                        <input name="imagen2" class="form-control-file" type="file"  required>             
                    </div> 
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="imagen3">Imagen 3</label>
                        <input name="imagen3" class="form-control-file" type="file" required>             
                    </div> 
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="video">Video</label>
                        <input name="video" class="form-control-file" type="file" required>             
                    </div> 
                </div>
                <div class="row">      
                    <div class="col-md-6 col-sm-6 col-lg-6">
                        <label for="categoria">Categoria</label>
                        <select name="categoria" id="ct">
                            <option value="1" selected>Smartphone</option>
                            <option value="2">Hogar</option>
                            <option value="3">Electronicos</option>
                            <option value="4">Juguetes</option>
                        </select>
                    </div>            
                </div>
                <div class="row">
                    <hr>
                </div>
                <div class="row">
                    <div class="form-check">
                        <input class="form-check-input" name="estado" type="checkbox" value="1" checked>
                        <label class="form-check-label" for="defaultCheck1">
                          En venta
                        </label>
                      </div>
                      </div>   
                <div class="row">
                      <div class="form-check">
                        <input class="form-check-input" name="estado" type="checkbox" value="2">
                        <label class="form-check-label" for="defaultCheck2">
                          En borrador
                        </label>
                      </div>
                </div>
                <div class="row">
                      
                    <input class="form-control" name="idProducto" type="number" value="<%= idpr%>" hidden>
                        
                      
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-6 col-lg-6">
                        <input type="submit" id="btnReg" class="btn btn-dark" value="Actualizar">
                    </div>
                </div>       
            </form>
        </div>
        <hr>
    <!-- FinRegistro -->


    <!-- Modal -->
    <!-- login -->
	<div class="modal fade" id="modalLogIn" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Login</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true"  id="xClose">&times;</span>
	        </button>
	      </div>
              <form action="inicioSesion" method="post">
	      <div class="modal-body">
              
                <div class="logInIn">
                    <div class="input-group form-group">
			<div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
			</div>
			<input type="text" class="form-control" name="usuario" placeholder="Usuario">
                    </div>
		</div>
		<div class="logInIn">
                    <div class="input-group form-group">
			<div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
			</div>
                        <input type="password" class="form-control" name="pass" placeholder="Contraseña">
                    </div>
                </div>
                             	                          
	      </div>
	      <div class="modal-footer">
                  <input type="submit" class="align-center btn btn-primary" id="btn-LogSign" value="Log In">
	      </div>
             </form>
            </div>
	  </div>
	</div>
		<!-- fin login -->

	


		<!-- fin modal -->
</body>
</html>

