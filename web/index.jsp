<%-- 
    Document   : index
    Author     : fernandourg
--%>
<%@page import="java.util.List"%>
<%@page import="Models.producto"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<producto> listpro;
    List<producto> listpro2;
    String nUsuario="";
    String isAdmin="";
                
    listpro = (List <producto>) request.getAttribute("libro_rate");                    
    listpro2 = (List <producto>) request.getAttribute("libro_date");
                    
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="height=device-height, width=device-width, initial-scale=1.0, maximum-scale=5.0, minimum-scale=1.0, viewport-fit=cover">
	<title>Landing Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/b26f182c55.js" crossorigin="anonymous"></script>
        <script type="text/javascript">
		$('.carousel').carousel()
		$(document).ready(function(){

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
                          <a class="navbar-brand" href="dashboard">Productos</a>
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

	<!-- carrusel -->

	<div class="container">
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
			    <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
			    <li data-target="#carouselExampleControls" data-slide-to="1"></li>
			    <li data-target="#carouselExampleControls" data-slide-to="2"></li>
			</ol>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="images/item.jpeg" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item">
			      <img src="images/item2.jpg" class="d-block w-100" alt="...">
			    </div>
			    <div class="carousel-item">
			      <img src="images/item3.png" class="d-block w-100" alt="...">
			    </div>
			  </div>
			  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
	</div>

	<!-- fin del carrusel -->
	<div class="container">
		<hr>
		<p class=text-left>Mejor Valorado</p>
		<!-- cards -->
			<div class="row">
                            <%
                                 for(producto lib : listpro){
                            %>
				<div class="col-4">
					<div class="card d-inline-block">
                                            <img src="getProductoImage?idprod=<%= lib.getIdproducto()%>" width="200px" height="200px" class="card-img-top" alt="...">
						<div class="card-body">
							<h5  class="card-title"><%= lib.getNombre()%></h5>
							<p class="card-text" maxlength="20"><%= lib.getDescripcion()%></p>
                                                        <a href="productoShow?idprod=<%= lib.getIdproducto()%>" class="btn btn-primary">Detalles</a>
							
						</div>
					</div>
				</div>
                            <%
                                }
                            %>		
			</div>
			<hr>
			
			<p class=text-left>Ultimo agregado</p>
			<div class="row">
                            <%
                                 for(producto lib2 : listpro2){
                            %>
				<div class="col-4">
					<div class="card d-inline-block">
						<img src="getProductoImage?idprod=<%= lib2.getIdproducto()%>" width="200px" height="200px" class="card-img-top" alt="...">
						<div class="card-body">
							<h5  class="card-title"><%= lib2.getNombre()%></h5>
							<p class="card-text" maxlength="20"><%= lib2.getDescripcion()%></p>
							<a href="productoShow?idprod=<%= lib2.getIdproducto()%>" class="btn btn-primary">Detalles</a>
							
						</div>
					</div>
				</div>
                             <%
                                }
                            %>	
			</div>
	</div>
	<!-- fin cards -->

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
