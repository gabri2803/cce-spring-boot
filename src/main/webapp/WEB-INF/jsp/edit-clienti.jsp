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
<form action="">
	<input type="hidden" name="id" value="${id}" />
	<input type="hidden" name="regioneSel" value="${regioneSel}" />
	Nome:
	<input type="text" name="nomeIns" value="${clienteIns.nome}"/><br>
	Cognome:
	<input type="text" name="cognomeIns" value="${clienteIns.cognome}"/><br>
	Codice Fiscale:
	<input type="text" name="codFis" value="${clienteIns.codiceFiscale}"/><br>
	Stato nascita:
	<input type="text" name="statoNasc" value="${clienteIns.statoNascita}"/><br>
	Seleziona la regione:
	<select name="reg">
		<c:forEach items="${listaRegioni}" var="regione">
		<c:choose>
			<c:when test="${regioneSel == regione}">
				<option value="${regione}" selected>${regione}</option>
				</c:when>
					<c:otherwise>
						<option value="${regione}">${regione}</option>
					</c:otherwise>
				</c:choose>
		</c:forEach>	
	</select><a href="/edit-page"><button>Cerca provincia ${idC}</button></a><br>
	Provincia di nascita:
	<select name="prov">
		<c:forEach items="${listaProvince}" var="provincia">
		<c:choose>
			<c:when test="${clienteIns.provinciaNascita == provincia}">
				<option value="${provincia}" selected>${provincia}</option>
				</c:when>
					<c:otherwise>
						<option value="${provincia}">${provincia}</option>
					</c:otherwise>
				</c:choose>
		</c:forEach>
	</select>
	<button>Cerca comune</button><br>
	Comune di nascita:
	<select name="com">
		<c:forEach items="${listaComuni}" var="comune">
			<c:choose>
			<c:when test="${clienteIns.comuneNascita == comune}">
				<option value="${comune}" selected>${comune}</option>
				</c:when>
					<c:otherwise>
						<option value="${comune}">${comune}</option>
					</c:otherwise>
				</c:choose>
		</c:forEach>
	</select><br>
	Data di nascita:
	<input type="text" name="dataNasc" value="${clienteIns.dataNascita}"/><br>
	Sesso:
	<input type="text" name="sessoIns" value="${clienteIns.sesso}"/><br>
	Numero di Telefono:
	<input type="text" name="telefonoIns" value="${clienteIns.telefono}"/><br>
	Cellulare:
	<input type="text" name="cellulareIns" value="${clienteIns.cellulare}"/><br>
	Ragione Sociale:
	<input type="text" name="ragSoc" value="${clienteIns.ragioneSociale}"/><br>
	Partita IVA:
	<input type="text" name="partIva" value="${clienteIns.partitaIva}"/><br>
	Banca di appoggio:
	<input type="text" name="banca" value="${clienteIns.bancaAppoggio}"/><br>
	ABI:
	<input type="text" name="abiIns" value="${clienteIns.abi}"/><br>
	CAB:
	<input type="text" name="cabIns" value="${clienteIns.cab}"/><br>
	Codice zona:
	<input type="text" name="codZona" value="${clienteIns.codiceZona}"/><br>
	Codice cliente:
	<input type="text" name="codCliente" value="${clienteIns.codiceCliente}"/><br>
	Stato:
	<input type="text" name="statoIns" value="${clienteIns.stato}"/><br>
	Tipo:
	<input type="text" name="tipoIns" value="${clienteIns.tipo}"/><br>
	Condizioni pagamento:
	<input type="text" name="condPag" value="${clienteIns.condizioniPagamento}"/><br>
	Note:
	<input type="text" name="noteIns" value="${clienteIns.note}"/><br>
	Email:
	<input type="text" name="emailIns" value="${clienteIns.email}"/>
</form>
</body>
</html>