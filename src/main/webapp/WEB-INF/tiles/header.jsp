<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle Navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand">setup-makeup</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/">Inicio</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<sec:authorize access="isAuthenticated()">
					<li><a href="<%=request.getContextPath()%>/categoria/listado">Listado</a></li>
				</sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="!isAuthenticated()">
					<li><a href="<%=request.getContextPath()%>/mi_pagina_login">Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">${pageContext.request.userPrincipal.name}
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="javascript:formSubmit()">Logout</a></li>
						</ul></li>

				</sec:authorize>
			</ul>

		</div>
	</div>
</nav>

<style>
body {
    color: #2b3636;
    font-family: "Proxima";
}

body {
    color: #333;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 14px;
    line-height: 1.42857;
}

.row {
    margin-left: -15px;
    margin-right: -15px;
}

*::before, *::after {
    box-sizing: border-box;
}

*::before, *::after {
    box-sizing: border-box;
}

.view-directory .course-listing {
    background-color: rgba(255, 255, 255, 0.7);
}

.course-listing {
    background-color: #f7f7f7;
    border: 1px solid #f1f3f0;
    border-radius: 9px;
    box-shadow: 0 1px #f1f3f0;
    cursor: pointer;
    height: 100px;
    margin-bottom: 50px;
    padding: 0;
}

* {
    box-sizing: border-box;
}

.course-listing .course-box-image-container {
    max-height: 208px;
    overflow: hidden;
}

.course-listing .course-box-image-container .course-box-image {
    border-bottom: 1px solid #ededed;
    border-top-left-radius: 9px;
    border-top-right-radius: 9px;
    display: block;
    margin: auto;
    width: 100%;
}

img {
    vertical-align: middle;
}

img {
    border: 0 none;
}

.course-listing .course-listing-title {
    color: #6cb44a;
    font-size: 18px;
    font-weight: bold;
    line-height: 25px;
    max-height: 70px;
    overflow: hidden;
    padding: 16px 16px 4px;
}

.course-listing .course-listing-subtitle {
    color: #586f6f;
    font-size: 14px;
    font-weight: 200;
    max-height: 65px;
    overflow: hidden;
    padding: 5px 16px;
}

.course-listing .course-listing-extra-info .course-price {
    color: #6eae50 !important;
    font-size: 15px;
    font-weight: bold;
    line-height: 34px;
    padding-right: 10px;
    text-align: right;
}

.course-listing .course-listing-extra-info .course-author-name {
    font-size: 15px;
    font-weight: 200;
    line-height: 30px;
    max-height: 30px;
    overflow: hidden;
    padding-left: 5px;
}

.course-listing .course-listing-extra-info .course-bundle {
    font-size: 15px;
    font-weight: 200;
    line-height: 30px;
}
</style>