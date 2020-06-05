<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="row">
	<c:if test="${empty miembro}">
		<div class="col-md-2">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<p>
					<a class="btn btn-default"
						href="<c:url value="/categoria/form.htm"/>" 
						role="button">Agregar categoria (+)</a>
				</p>
			</sec:authorize>
		</div>
	</c:if>
	<c:if test="${empty categoria }">
		<div class="col-md-2">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<p>
					<a class="btn btn-default" 
						href="<c:url value="/miembro/form.htm"/>"
						role="button">Agregar miembro (+)</a>
				</p>
			</sec:authorize>
		</div>
	</c:if>
</div>

<div class="container">
	<div class="row">

		<div class="row course-list list"  style='padding-top: 2%;'>
			<c:forEach items="${categorias}" var="categoria">
				<div class="col-md-4" style='text-align: center;'>
					<div class="course-listing">
						<div class="row">
							<a href="product.html">
								<div class="col-lg-12">
									<div class="course-listing-title">
										<h3><c:out value="${categoria.nombre}" /></h3>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</div>