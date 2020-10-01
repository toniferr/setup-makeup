<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-header">
	<h1>
		<small>Nueva Categoría</small>
	</h1>
</div>

<a class="btn btn-default" href="<c:url value="/categoria/listado"/>"
	role="button">Volver</a>

<div class="panel panel-primary" style="margin-top: 1%;">
	<div class="panel-heading">
		<c:out value="${titulo}" />
	</div>
	<div class="panel-body">

		<div class="container">
			<div class="row">

				<form:form modelAttribute="categoria" method="post"
					cssClass="form-horizontal" role="form">
					
					<form:label for="nombre" path="nombre"
							cssClass="col-sm-2 control-label">Nombre</form:label>
							
					<div class="form-group">						
						<div class="col-sm-10">
							<form:input path="nombre" style="width: 300px;"
								cssClass="form-control"
								cssErrorClass="form-control alert-danger" />
							<form:errors path="nombre" />
						</div>
					</div>
					
					<form:input type="hidden" path="categoriaPadre"/>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" value="Crear Categoria"
								class="btn btn-primary" role="button" />
						</div>
					</div>	
									
				</form:form>
			</div>
		</div>
	</div>
</div>

