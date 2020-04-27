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
	<input type="text" name="id" value="${clienteIns.id}"></input>
	<input type="hidden" name="regioneSel" value="${regioneSel}"></input>
	Nome:
	<input type="text" name="nomeIns" value="${clienteIns.nome}"></input><br>
	Cognome:
	<input type="text" name="cognomeIns" value="${clienteIns.cognome}"></input><br>
	Codice Fiscale:
	<input type="text" name="codiceFiscaleIns" value="${clienteIns.codiceFiscale}"></input><br>
	Stato nascita:
	<input type="text" name="statoNascitaIns" value="${clienteIns.statoNascita}"></input><br>
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
	</select><a href="/edit-page?id=${clienteIns.id}"><button>Cerca provincia ${idC}</button></a><br>
	Provincia di nascita:
	<select name="provinciaNascitaIns">
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
	<a href="/edit-page?id=${clienteIns.id}"><button>Cerca comune</button></a><br>
	Comune di nascita:
	<select name="comuneNascitaIns">
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
	<input type="text" name="dataNascitaIns" value="${clienteIns.dataNascita}"></input><br>
	Sesso:
	<input type="text" name="sessoIns" value="${clienteIns.sesso}"></input><br>
	Numero di Telefono:
	<input type="text" name="telefonoIns" value="${clienteIns.telefono}"></input><br>
	Cellulare:
	<input type="text" name="cellulareIns" value="${clienteIns.cellulare}"></input><br>
	Ragione Sociale:
	<input type="text" name="ragioneSocialeIns" value="${clienteIns.ragioneSociale}"></input><br>
	Partita IVA:
	<input type="text" name="partitaIvaIns" value="${clienteIns.partitaIva}"></input><br>
	Banca di appoggio:
	<input type="text" name="bancaAppoggioIns" value="${clienteIns.bancaAppoggio}"></input><br>
	ABI:
	<input type="text" name="abiIns" value="${clienteIns.abi}"></input><br>
	CAB:
	<input type="text" name="cabIns" value="${clienteIns.cab}"></input><br>
	Codice zona:
	<input type="text" name="codiceZonaIns" value="${clienteIns.codiceZona}"></input><br>
	Codice cliente:
	<input type="text" name="codiceClienteIns" value="${clienteIns.codiceCliente}"></input><br>
	Stato:
	<input type="text" name="statoIns" value="${clienteIns.stato}"></input><br>
	Tipo:
	<input type="text" name="tipoIns" value="${clienteIns.tipo}"></input><br>
	Condizioni pagamento:
	<input type="text" name="condizioniPagamentoIns" value="${clienteIns.condizioniPagamento}"></input><br>
	Note:
	<input type="text" name="noteIns" value="${clienteIns.note}"></input><br>
	Email:
	<input type="text" name="emailIns" value="${clienteIns.email}"></input>
</form>
	<a href="/edit-cliente"><button>Salva</button></a>
</body>
</html>