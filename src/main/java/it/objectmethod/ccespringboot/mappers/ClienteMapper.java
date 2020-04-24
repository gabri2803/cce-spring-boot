package it.objectmethod.ccespringboot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.ccespringboot.model.Cliente;

public class ClienteMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id"));
		cliente.setRagioneSociale(rs.getString("ragione_sociale"));
		cliente.setCodiceFiscale(rs.getString("codice_fiscale"));
		cliente.setTelefono(rs.getString("telefono"));
		cliente.setPartitaIva(rs.getString("partita_iva"));
		cliente.setBancaAppoggio(rs.getString("banca_appoggio"));
		cliente.setAbi(rs.getString("abi"));
		cliente.setCab(rs.getString("cab"));
		cliente.setCodiceZona(rs.getString("codice_zona"));
		cliente.setCodiceCliente(rs.getString("codice_cliente"));
		cliente.setStato(rs.getString("stato"));
		cliente.setCellulare(rs.getString("cellulare"));
		cliente.setCognome(rs.getString("cognome"));
		cliente.setComuneNascita(rs.getString("comune_nascita"));
		cliente.setNome(rs.getString("nome"));
		cliente.setProvinciaNascita(rs.getString("provincia_nascita"));
		cliente.setSesso(rs.getString("sesso"));
		cliente.setStatoNascita(rs.getString("stato_nascita"));
		cliente.setTipo(rs.getString("tipo"));
		cliente.setDataNascita(rs.getString("data_nascita"));
		cliente.setCondizioniPagamento(rs.getString("condizioni_pagamento"));
		cliente.setNote(rs.getString("note"));
		cliente.setEmail(rs.getString("email"));
		return cliente;
	}

}
