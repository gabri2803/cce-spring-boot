<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/lista-clienti"><button>Lista Clienti</button></a>
	<a href="/edit-page?id=-1"><button>Inserisci un nuovo
			cliente</button></a>
	<p>${message}</p>
	<ul>
		<c:forEach items="${clientiList}" var="cliente">
			<li>${cliente.nome}<br><a href="/edit-page?id=${cliente.id}"><button>Modifica</button></a>
				<br><a href="/delete-client?id=${cliente.id}"><button>Elimina
						cliente</button></a></li>
		</c:forEach>
	</ul>
</body>
</html>