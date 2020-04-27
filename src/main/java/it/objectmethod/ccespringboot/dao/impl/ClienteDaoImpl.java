package it.objectmethod.ccespringboot.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.ccespringboot.dao.IClienteDao;
import it.objectmethod.ccespringboot.mappers.ClienteMapper;
import it.objectmethod.ccespringboot.model.Cliente;

@Service
public class ClienteDaoImpl extends NamedParameterJdbcDaoSupport implements IClienteDao {

	@Autowired
	public ClienteDaoImpl(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<Cliente> getAllClienti() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clienti = getJdbcTemplate().query(sql, new ClienteMapper());
		return clienti;
	}

	@Override
	public Cliente getClienteById(int id) {
		String sql = "SELECT * FROM cliente WHERE id=?";
		Cliente cliente = getJdbcTemplate().queryForObject(sql, new Object[] { id }, new ClienteMapper());
		return cliente;
	}

	@Override
	public void postCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (ragione_sociale, codice_fiscale, telefono, partita_iva, banca_appoggio, abi, cab, codice_zona, codice_cliente, stato, cellulare, cognome, comune_nascita, nome, provincia_nascita, sesso, stato_nascita, tipo, data_nascita, condizioni_pagamento, note, email)"
				+ " VALUES (:ragione, :codFisc, :telefonoIns, :iva, :banca, :abiIns, :cabIns, :codZona, :codCli, :statoIns, :cellulareIns, :cognomeIns, :comNasc, :nomeIns, :provNasc, :sessoIns, :statoNasc, :tipoIns, :dataNasc, :pagamento, :noteIns, :emailIns)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ragione", cliente.getRagioneSociale());
		params.addValue("codFisc", cliente.getCodiceFiscale());
		params.addValue("telefonoIns", cliente.getTelefono());
		params.addValue("iva", cliente.getPartitaIva());
		params.addValue("banca", cliente.getBancaAppoggio());
		params.addValue("abiIns", cliente.getAbi());
		params.addValue("cabIns", cliente.getCab());
		params.addValue("codZona", cliente.getCodiceZona());
		params.addValue("codCli", cliente.getCodiceCliente());
		params.addValue("statoIns", cliente.getStato());
		params.addValue("cellulareIns", cliente.getCellulare());
		params.addValue("cognomeIns", cliente.getCognome());
		params.addValue("comNasc", cliente.getComuneNascita());
		params.addValue("nomeIns", cliente.getNome());
		params.addValue("provNasc", cliente.getProvinciaNascita());
		params.addValue("sessoIns", cliente.getSesso());
		params.addValue("statoNasc", cliente.getStatoNascita());
		params.addValue("tipoIns", cliente.getTipo());
		params.addValue("dataNasc", cliente.getDataNascita());
		params.addValue("pagamento", cliente.getCondizioniPagamento());
		params.addValue("noteIns", cliente.getNote());
		params.addValue("emailIns", cliente.getEmail());
		getNamedParameterJdbcTemplate().update(sql, params);
	}

	@Override
	public void putCliente(Cliente cliente) {
		String sql = "UPDATE cliente SET ragione_sociale = :ragione, codice_fiscale = :codFisc, telefono = :telefonoIns, partita_iva = :iva, banca_appoggio = :banca, abi = :abiIns, cab = :cabIns, codice_zona = :codZona, codice_cliente = :codCli, stato = :statoIns, cellulare = :cellulareIns, cognome = :cognomeIns, comune_nascita = :comNasc, nome = :nomeIns, provincia_nascita = :provNasc, sesso = :sessoIns, stato_nascita = :statoNasc, \r\n"
				+ "tipo = :tipoIns, data_nascita = :dataNasc, condizioni_pagamento = :pagamento, note = :noteIns, email = :emailIns WHERE id = :idIns";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("ragione", cliente.getRagioneSociale());
		params.addValue("codFisc", cliente.getCodiceFiscale());
		params.addValue("telefonoIns", cliente.getTelefono());
		params.addValue("iva", cliente.getPartitaIva());
		params.addValue("banca", cliente.getBancaAppoggio());
		params.addValue("abiIns", cliente.getAbi());
		params.addValue("cabIns", cliente.getCab());
		params.addValue("codZona", cliente.getCodiceZona());
		params.addValue("codCli", cliente.getCodiceCliente());
		params.addValue("statoIns", cliente.getStato());
		params.addValue("cellulareIns", cliente.getCellulare());
		params.addValue("cognomeIns", cliente.getCognome());
		params.addValue("comNasc", cliente.getComuneNascita());
		params.addValue("nomeIns", cliente.getNome());
		params.addValue("provNasc", cliente.getProvinciaNascita());
		params.addValue("sessoIns", cliente.getSesso());
		params.addValue("statoNasc", cliente.getStatoNascita());
		params.addValue("tipoIns", cliente.getTipo());
		params.addValue("dataNasc", cliente.getDataNascita());
		params.addValue("pagamento", cliente.getCondizioniPagamento());
		params.addValue("noteIns", cliente.getNote());
		params.addValue("emailIns", cliente.getEmail());
		params.addValue("idIns", cliente.getId());
		getNamedParameterJdbcTemplate().update(sql, params);
	}

}
