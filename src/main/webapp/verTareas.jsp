<%@page import="java.util.List"%>
<%@page import="com.tracom.entidades.User"%>
<%@page import="com.tracom.entidades.Task"%>
<%@page import="com.tracom.DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<%@include file="components/header.jsp"%>

<body id="page-top">
	<%
	HttpSession misession = request.getSession();
	User userLogin = (User) request.getSession().getAttribute("user");
	if(userLogin == null){
		
		response.sendRedirect("login.jsp");
	}
	%>

	
	


	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@include file="components/barraLateral.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
								<!-- Topbar -->

				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">



					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">



						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"><%=userLogin.getName()%>></span>
								<img class="img-profile rounded-circle"
								src="img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>



				<!-- End of Topbar -->
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<h1 class="text-center">Lista Tareas</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Tareas</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Nombre Tarea</th>
											<th>Descripcion</th>
											<th>Fecha Creacion</th>
											<th>Fecha Actualizacion</th>
											<th>Acciones</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>Nombre Tarea</th>
											<th>Descripcion</th>
											<th>Fecha Creacion</th>
											<th>Fecha Actualizacion</th>
											<th>Acciones</th>
										</tr>
									</tfoot>
									<tbody>

										<%
										UserDAO uDAO = new UserDAO();
										User u = uDAO.buscarUserPorId(id);
										List<Task> listaTarea = u.getListTask();

										for (Task t : listaTarea) {
										%>

										<tr>
											<td><%=t.getName()%></td>
											<td><%=t.getDescription()%></td>
											<td><%=t.getFechaCreacion()%></td>
											<td><%=t.getFechaActualizacion() != null ? t.getFechaActualizacion() : "Nunca"%></td>
											<td style="display: flex; justify-content: space-around">

												<form name="editar" action="SvTarea" method="POST">
													<button class="btn btn-success btn-user btn-block ">
														<i class="fas fa-pencil-alt"></i>
													</button>
													<input type="hidden" name="idTask" value="<%=t.getId()%>">
													<input type="hidden" name="tipo" value="editar">
												</form>


												<form name="eliminar" action="SvTarea" method="POST">
													<button class="btn btn-danger btn-user btn-block">
														<i class="fas fa-trash-alt"></i>
													</button>
													<input type="hidden" name="idTask" value="<%=t.getId()%>">
													<input type="hidden" name="tipo" value="eliminar">
												</form>




											</td>
										</tr>

										<%
										}
										%>


									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<%@ include file="components/footer.jsp"%>

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<%@ include file="components/script.jsp"%>



</body>

</html>