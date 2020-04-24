package it.objectmethod.ccespringboot.dao;

import java.util.List;

import it.objectmethod.ccespringboot.model.Cliente;

public interface IClienteDao {

	public List<Cliente> getAllClienti();

	public Cliente getClienteById(int id);
}
