<%-- 
    Document   : producto
    Created on : 26/11/2019, 06:07:03 AM
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
    int likes =(Integer) request.getAttribute("cntLikes");
    int dislikes =(Integer) request.getAttribute("cntDislikes");
    int idpro= listpro.getIdproducto();
    
                    
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
		
		$(document).ready(function(){
                 $("#btnDel").click(function(){
                    var conf = confirm("Deseas borrar este Producto?")
                     if(conf === true){
                         window.location.href = "borrarProducto?idprod=<%= listpro.getIdproducto()%>";
                     }
                 });
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
						 <a class="navbar-brand" href="logOut">Salir</a>
					</li>
                                        <li class="nav-item">
						 <a class="navbar-brand" href="shwCart"><i class="fas fa-shopping-cart"></i></a>
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

	<div class="container">
        	<div class="row">
               <div class="col-xs-4 item-photo">
                   <img id="imgProduct" src="getProductoImage?idprod=<%= listpro.getIdproducto()%>" width="400px" height="500px" />
                </div>
                <div class="col-xs-4 item-photo">
                    <% String temp = listpro.getVideo();
                   
                     String fileName = this.getServletContext().getRealPath("/VIDEOS");
                      String dir = "/PapwStore/VIDEOS/"+temp;
                    %>
                    <video width="400px" height="500px" controls>
                        <source src="<%=dir%>" type="video/mp4">
                    </video>
                </div>
                <div class="col-xs-5">
                    <!-- Datos del vendedor y titulo del producto -->
                    <h3><%= listpro.getNombre()%></h3>    
                    <h5 >Vendido por <a href="#">Vendedor</a> · <small>(666 ventas)</small></h5>
        
                    <!-- Precios -->
                    
                    <h3 >Precio negociable</h3>
        
                    <!-- Detalles especificos del producto -->
                    
                     
                    <div class="section">
                        <h6 class="title-attr"><small>CANTIDAD</small></h6>                    
                        <div>
                            <div class="btn-minus"><span><i class="fas fa-minus"></i></span></div>
                            <input value="1" />
                            <div class="btn-plus"><span><i class="fas fa-plus"></i></span></div>
                        </div>
                    </div>                
                    <form action="valoracion" method="GET" enctype="multipart/form-data">
                        <div class="row">
                            <input type="text" name="proID" value="<%= idpro%>" hidden/>
                        <button type="submit" name="Like" class="btn btn-primary"><i class="far fa-thumbs-up"></i></button>
                        <label><%=likes%></label>
                        <button type="submit" name="Dislike"class="btn btn-primary"><i class="far fa-thumbs-down"></i></button>
                        <label><%=dislikes%></label>
                        </div>
                    </form>
                    <!-- Botones de compra -->
                    <div class="section">
                        <%
                            if(isAdmin.equals("Administrador")){
                        %>
                        <a class="btn btn-primary"  href="editarProducto?idprod=<%= listpro.getIdproducto()%>"><span aria-hidden="true"></span><i class="fas fa-edit"></i>Editar Producto</a>
                        <br>
                        <a class="btn btn-danger"  href="#" id="btnDel"><span aria-hidden="true"></span><i class="fas fa-trash-alt"></i>Eliminar Producto</a>
                        <% 
                            }else{
                        %>
                        <a class="btn btn-primary" id="btncomprar" href="addToCart?idprod=<%= listpro.getIdproducto()%>&idusu=<%=nUsuario%>"><span aria-hidden="true"></span><i class="fas fa-shopping-cart"></i> Agregar al carro</a>
                        <%
                        }
                        %>
                    </div>                                        
                </div>                              
        
                <div class="col-xs-9">
                    <ul class="menu-items">
                        <li class="active">Detalle del producto</li>
                        
                    </ul>
                    <div class="contenedor-info">
                        <p id="infoProduct">
                            <small>
                      		<%= listpro.getDescripcion()%>	
                            </small>

                        </p>
                        
                    </div>
                </div>		
            </div>
        </div> 
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
