package it.objectmethod.ccespringboot.dao;

import java.util.List;

import it.objectmethod.ccespringboot.model.Cliente;

public interface IClienteDao {

	public List<Cliente> getAllClienti();

	public Cliente getClienteById(int id);

	public void postCliente(Cliente cliente);

	public void putCliente(Cliente cliente);

	Cliente salvaVariabili(String nome, String cognome, String codFisc, String statoNasc, String provNasc,
			String comNasc, String dataNasc, String sesso, String telef, String cell, String ragSoc, String iva,
			String bancaAp, String abi, String cab, String codZona, String codCli, String stato, String tipo,
			String condPag, String note, String email);

	void deleteCliente(int id);
}
