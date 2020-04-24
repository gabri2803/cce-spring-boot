package it.objectmethod.ccespringboot.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import it.objectmethod.ccespringboot.model.Cliente;

@Service
public interface IClienteDao {

	public List<Cliente> getAllClienti();

	public Cliente getClienteById(int id);
}
