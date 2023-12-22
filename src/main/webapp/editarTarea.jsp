<%@page import="com.tracom.entidades.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<%@include file="components/header.jsp"%>

<body id="page-top">

	<!--Validacion Sesion  -->
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

					<h1 class="text-center">Editar Tarea</h1>

					<form class="user" action="SvTarea" method="POST">
						<div class="form-group">
							<input type="text" class="form-control form-control-user"
								id="nameTask" name="nameTask" placeholder="Nombra Tu Tarea"
								value="<%=taskEdit.getName()%>" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control form-control-user"
								id="description" name="description" placeholder="Descripcion"
								value="<%=taskEdit.getDescription()%>">
						</div>

						<input type="hidden" name="tipo" value="actulizar"> <input
							type="hidden" name="idTask" value="<%=taskEdit.getId()%>">

						<button class="btn btn-primary btn-user btn-block">Actualizar
						</button>

					</form>

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