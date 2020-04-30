<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-sm">
		<div class="col-sm-4">
			<a href="/lista-clienti"><button class="btn btn-primary">Lista
					Clienti</button></a> <a href="/edit-page?id=-1"><button
					class="btn btn-primary">Inserisci un nuovo cliente</button></a>
			<p>${message}</p>
			<ul class="list-group list-group-flush">
				<c:forEach items="${clientiList}" var="cliente">
					<li class="list-group-item"><h2>${cliente.nome}</h2><br>
					<a href="/edit-page?id=${cliente.id}"><button
								class="btn btn-primary btn-sm">Modifica</button></a> <a
						href="/delete-client?id=${cliente.id}"><button
								class="btn btn-danger btn-sm">Elimina cliente</button></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>