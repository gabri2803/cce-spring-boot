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
	<form action="/drop-menu" method="POST">
		<input type="text" name="id" value="${id}"></input><br>
		 Nome: <input type="text" name="nomeIns"
			value="${clienteIns.nome}"></input><br> Cognome: <input
			type="text" name="cognomeIns" value="${clienteIns.cognome}"></input><br>
		Codice Fiscale: <input type="text" name="codiceFiscaleIns"
			value="${clienteIns.codiceFiscale}"></input><br> Stato nascita:
		<input type="text" name="statoNascitaIns"
			value="${clienteIns.statoNascita}"></input><br> Provincia di
		nascita: <input type="text" name="provinciaNascitaSel"
			value="${provinciaSel}" /><br> 
			Comune di
		nascita: <input type="text" name="comuneNascitaSel"
			value="${comuneSel}" /><br>
			<hr>
			Modifica comune di nascita:<br>
			Seleziona la regione: <select name="regioneSel"
			onchange="this.form.submit()">
			<option value="">------</option>
			<c:forEach items="${listaRegioni}" var="regione">
				<c:choose>
					<c:when test="${regione == regioneIns}">
						<option value="${regione}" selected>${regione}</option>
					</c:when>
					<c:otherwise>
						<option value="${regione}">${regione}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br> Seleziona provincia: <select name="provinciaNascitaIns"
			onchange="this.form.submit()">
			<option value="">------</option>
			<c:forEach items="${listaProvince}" var="provincia">
				<c:choose>
					<c:when test="${ provincia == provinciaSel}">
						<option value="${provincia}" selected>${provincia}</option>
					</c:when>
					<c:otherwise>
						<option value="${provincia}">${provincia}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br> Seleziona comune: <select name="comuneNascitaIns"
			onchange="this.form.submit()">
			<option value="">------</option>
			<c:forEach items="${listaComuni}" var="comune">
				<c:choose>
					<c:when test="${comune == comuneSel}">
						<option value="${comune}" selected>${comune}</option>
					</c:when>
					<c:otherwise>
						<option value="${comune}">${comune}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select><br><hr>
			 Data di nascita: <input
			type="text" name="dataNascitaIns" value="${clienteIns.dataNascita}"></input><br>
		Sesso: 
		<c:choose>
			<c:when test="${clienteIns.sesso == sessoM}">
				<input type="radio" id="male" name="sessoIns" value="${clienteIns.sesso}" checked>
			<label for="male">M</label>
			</c:when>
			<c:otherwise>
				<input type="radio" id="male" name="sessoIns" value="M"><label for="male">M</label>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${clienteIns.sesso == sessoF}">
				<input type="radio" id="female" name="sessoIns" value="${clienteIns.sesso}" checked>
				<label for="female">F</label>
			</c:when>
			<c:otherwise>
				<input type="radio" id="female" name="sessoIns" value="F"><label for="female">F</label>
			</c:otherwise>
		</c:choose>
		 <br> Numero di Telefono: <input
			type="text" name="telefonoIns" value="${clienteIns.telefono}"></input><br>
		Cellulare: <input type="text" name="cellulareIns"
			value="${clienteIns.cellulare}"></input><br> Ragione Sociale: <input
			type="text" name="ragioneSocialeIns"
			value="${clienteIns.ragioneSociale}"></input><br> Partita IVA: <input
			type="text" name="partitaIvaIns" value="${clienteIns.partitaIva}"></input><br>
		Banca di appoggio: <input type="text" name="bancaAppoggioIns"
			value="${clienteIns.bancaAppoggio}"></input><br> ABI: <input
			type="text" name="abiIns" value="${clienteIns.abi}"></input><br>
		CAB: <input type="text" name="cabIns" value="${clienteIns.cab}"></input><br>
		Codice zona: <input type="text" name="codiceZonaIns"
			value="${clienteIns.codiceZona}"></input><br> Codice cliente: <input
			type="text" name="codiceClienteIns"
			value="${clienteIns.codiceCliente}"></input><br> Stato: <input
			type="text" name="statoIns" value="${clienteIns.stato}"></input><br>
		Tipo: 
		<c:choose>
			<c:when test="${clienteIns.tipo == tipoPg}">
				<input type="radio" id="pg" name="tipoIns" value="${clienteIns.tipo}" checked>
			<label for="pg">PG</label>
			</c:when>
			<c:otherwise>
				<input type="radio" id="pg" name="tipoIns" value="PG"><label for="pg">PG</label>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${clienteIns.tipo == tipoPs}">
				<input type="radio" id="ps" name="tipoIns" value="${clienteIns.tipo}" checked>
				<label for="ps">PS</label>
			</c:when>
			<c:otherwise>
				<input type="radio" id="ps" name="tipoIns" value="PS"><label for="ps">PS</label>
			</c:otherwise>
		</c:choose><br>
		Condizioni pagamento: <input type="text" name="condizioniPagamentoIns"
			value="${clienteIns.condizioniPagamento}"></input><br> Note: <input
			type="text" name="noteIns" value="${clienteIns.note}"></input><br>
		Email: <input type="text" name="emailIns" value="${clienteIns.email}"></input><br>
		<button type="submit" formaction="/edit-cliente">Salva</button>
	</form>
</body>
</html>