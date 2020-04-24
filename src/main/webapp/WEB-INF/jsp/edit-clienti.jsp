<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" name="idC" value="idC" />
	Ragione Sociale:
	<input type="text" name="ragSoc" value="${clienteIns.ragioneSociale}"/><br>
	Codice Fiscale:
	<input type="text" name="codFis" value="${clienteIns.codiceFiscale}"/><br>
	Numero di Telefono:
	<input type="text" name="telefonoIns" value="${clienteIns.telefono}"/><br>
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
	Cellulare:
	<input type="text" name="cellulareIns" value="${clienteIns.cellulare}"/><br>
	Cognome:
	<input type="text" name="cognomeIns" value="${clienteIns.cognome}"/><br>
	Comune di nascita:
	<input type="text" name="comuneNasc" value="${clienteIns.comuneNascita}"/><br>
	Nome:
	<input type="text" name="nomeIns" value="${clienteIns.nome}"/><br>
	Provincia di nascita:
	<input type="text" name="provNasc" value="${clienteIns.provinciaNascita}"/><br>
	Sesso:
	<input type="text" name="sessoIns" value="${clienteIns.sesso}"/><br>
	Stato nascita:
	<input type="text" name="statoNasc" value="${clienteIns.statoNascita}"/><br>
	Tipo:
	<input type="text" name="tipoIns" value="${clienteIns.tipo}"/><br>
	Data di nascita:
	<input type="text" name="dataNasc" value="${clienteIns.dataNascita}"/><br>
	Condizioni pagamento:
	<input type="text" name="condPag" value="${clienteIns.condizioniPagamento}"/><br>
	Note:
	<input type="text" name="noteIns" value="${clienteIns.note}"/><br>
	Email:
	<input type="text" name="emailIns" value="${clienteIns.email}"/>
</body>
</html>