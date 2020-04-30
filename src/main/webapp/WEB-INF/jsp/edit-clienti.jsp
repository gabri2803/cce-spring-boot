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
	<div class="container">
		<div class="col-sm-8">
			<h1>Inserisci o modifica il cliente</h1>
			<form action="/drop-menu" method="POST">
				<input type="hidden" name="id" value="${id}"></input><br> Nome:
				<input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="nomeIns"
					value="${clienteIns.nome}"></input><br> Cognome: <input
					class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" type="text"
					name="cognomeIns" value="${clienteIns.cognome}"></input><br>
				Codice Fiscale: <input class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" type="text"
					name="codiceFiscaleIns" value="${clienteIns.codiceFiscale}"></input><br>
				Stato nascita: <input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="statoNascitaIns"
					value="${clienteIns.statoNascita}"></input><br> Provincia di
				nascita: <input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="provinciaNascitaSel"
					value="${provinciaSel}" /><br> Comune di nascita: <input
					type="text" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="comuneNascitaSel"
					value="${comuneSel}" /><br>
				<hr>
				<div class="col-sm-6">
					Modifica comune di nascita:<br> Seleziona la regione: <select
						class="custom-select" name="regioneSel"
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
					</select><br> Seleziona provincia: <select class="custom-select"
						name="provinciaNascitaIns" onchange="this.form.submit()">
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
					</select><br> Seleziona comune: <select class="custom-select"
						name="comuneNascitaIns" onchange="this.form.submit()">
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
					</select><br>
				</div>
				<hr>
				Data di nascita: <input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="dataNascitaIns"
					value="${clienteIns.dataNascita}"></input><br> Sesso:
				<c:choose>
					<c:when test="${clienteIns.sesso == sessoM}">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="sessoIns"
								value="${clienteIns.sesso}" id="male" checked> <label
								class="form-check-label" for="male"> M </label>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="sessoIns"
								value="M" id="male"> <label class="form-check-label"
								for="male"> M </label>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${clienteIns.sesso == sessoF}">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="sessoIns"
								value="${clienteIns.sesso}" id="female" checked> <label
								class="form-check-label" for="female"> F </label>
						</div>
						<input type="radio" id="female" name="sessoIns"
							value="${clienteIns.sesso}" checked>
						<label for="female">F</label>
					</c:when>
					<c:otherwise>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="sessoIns"
								value="F" id="female"> <label class="form-check-label"
								for="female"> F </label>
						</div>
					</c:otherwise>
				</c:choose>
				<br> Numero di Telefono: <input class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" type="text"
					name="telefonoIns" value="${clienteIns.telefono}"></input><br>
				Cellulare: <input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="cellulareIns"
					value="${clienteIns.cellulare}"></input><br> Ragione Sociale:
				<input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="ragioneSocialeIns"
					value="${clienteIns.ragioneSociale}"></input><br> Partita IVA:
				<input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="partitaIvaIns"
					value="${clienteIns.partitaIva}"></input><br> Banca di
				appoggio: <input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="bancaAppoggioIns"
					value="${clienteIns.bancaAppoggio}"></input><br> ABI: <input
					type="text" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="abiIns"
					value="${clienteIns.abi}"></input><br> CAB: <input type="text"
					class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="cabIns"
					value="${clienteIns.cab}"></input><br> Codice zona: <input
					type="text" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="codiceZonaIns"
					value="${clienteIns.codiceZona}"></input><br> Codice cliente:
				<input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="codiceClienteIns"
					value="${clienteIns.codiceCliente}"></input><br> Stato: <input
					type="text" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="statoIns"
					value="${clienteIns.stato}"></input><br> Tipo:

				<c:choose>
					<c:when test="${clienteIns.tipo == tipoPg}">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="tipoIns"
								value="${clienteIns.tipo}" id="pg" checked> <label
								class="form-check-label" for="pg"> PG </label>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-check">
							<input class="form-check-input" name="tipoIns" type="checkbox"
								value="PG" id="pg"> <label class="form-check-label"
								for="pg"> PG </label>
						</div>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${clienteIns.tipo == tipoPs}">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="tipoIns"
								value="${clienteIns.tipo}" id="ps" checked> <label
								class="form-check-label" for="ps"> PS </label> <input
								type="radio" id="ps" name="tipoIns" value="${clienteIns.tipo}"
								checked> <label for="ps">PS</label>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-check">
							<input class="form-check-input" type="checkbox" name="tipoIns"
								value="PS" id="ps"> <label class="form-check-label"
								for="ps"> PS </label>
						</div>
					</c:otherwise>
				</c:choose>
				<br> Condizioni pagamento: <input type="text"
					class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm"
					name="condizioniPagamentoIns"
					value="${clienteIns.condizioniPagamento}"></input><br> Note: <input
					type="text" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="noteIns"
					value="${clienteIns.note}"></input><br> Email: <input
					type="text" class="form-control" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="emailIns"
					value="${clienteIns.email}"></input><br>
				<button class="btn btn-success" type="submit"
					formaction="/edit-cliente">Salva</button>
			</form>
		</div>
	</div>
</body>
</html>