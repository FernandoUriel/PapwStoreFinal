<%@page import="Models.Compra"%>
<%@page import="Models.Chat"%>
<%@page import="Models.Mensaje"%>
<%@page import="java.util.List"%>
<%@page import="Models.producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nUsuario="";
    String isAdmin="";
    List<Compra>  liC; 
    liC= (List<Compra>) request.getAttribute("HiCom");
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
        
    <!-- Lista de chat -->
    
   	<div class="container">
            <br>
            
            <form action="filtroHistorial"method="GET">
                <div class="row">
                    <div class="col-sm-6">
                        <select name="filtro"class="custom-select mr-sm-2">
                            <option value="0" selected></option>
                            <option value="1">Nombre</option>
                            <option value="2">Fecha</option>
                            <option value="3">Precio</option>
                            <option value="4">Unidades</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <input type="submit" value="Ordenar" class="btn btn-info">
                    </div>
                </div>
            </form>
            <br>
             <form action="filtroHistorial2"method="GET">
                <div class="row">
                    <div class="col-sm-6">
                        <select name="filtroB"class="custom-select mr-sm-2">
                            <option value="0" selected></option>
                            <option value="1">Nombre</option>
                            <option value="2">Fecha</option>
                            <option value="3">Precio</option>
                            <option value="4">Unidades</option>
                        </select>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="prBus">
                    </div>
                    <div class="col-sm-3">
                        <input type="submit" value="Buscar" class="btn btn-info">
                    </div>
                    
                </div>
            </form>
            <br>
		<table class="table table-hover table-condensed">
			<thead class="thead-dark">
				<tr>
					<th >Producto</th>
					<th >Precio</th>
					<th >Cantidad</th>
					<th >Total</th>
					<th class="text-center">Fecha</th>
					<th >Metodo de Pago</th>
				</tr>
			</thead>
                        
                        <%
                            for(Compra cM : liC){
                        %>
			<tbody>
				<tr>
					<td data-th="Product">
						<div class="row">
							
								<div class="col-sm-10">
                                                                    <h4 id="productTitle" class="nomargin"><%= cM.getNombre()%></h4>
									
								</div>
							</div>
					</td>
						<td data-th="Price"><%= cM.getPrecio()%></td>
						<td>
								<label class="text-center" value="1"><%= cM.getUnidades()%></label>
						</td>
                                                
                                                <% int Total = cM.getPrecio()*cM.getUnidades();%>
                                                <td data-th="Subtotal" class="text-center"><%=Total%></td>
						<td data-th="Subtotal" class="text-center"><%= cM.getFecha()%></td>
						<td class="actions" data-th="">
                                                    <% String Metodo;
                                                    if(cM.getFormapago()==1)
                                                    {
                                                        Metodo="Tarjeta";
                                                        
                                                    }else{
                                                        Metodo="Efectivo";
                                                    }
                                                    %>
                                                    <%=Metodo%>
						</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					
					<td colspan="1" class="hidden-xs"></td>
					<td colspan="1" class="hidden-xs"></td>
					<td colspan="1" class="hidden-xs"></td>
					<td colspan="1" class="hidden-xs"></td>
					<td colspan="1" class="hidden-xs"></td>
					<td colspan="1" class="hidden-xs"></td>
					
				</tr>
			</tfoot>
                        <%
                            }
                        %>
		</table>
	</div>

    
    <!-- Fin de lista de Chat -->
    
    
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

