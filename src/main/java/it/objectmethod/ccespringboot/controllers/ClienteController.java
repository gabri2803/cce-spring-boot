package it.objectmethod.ccespringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.ccespringboot.dao.IClienteDao;
import it.objectmethod.ccespringboot.model.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;

	@RequestMapping("/lista-clienti")
	public String listaClienti(ModelMap model) {
		List<Cliente> clienti = clienteDao.getAllClienti();
		model.put("clientiList", clienti);
		return "list-clients";
	}

	@RequestMapping("/edit-cliente")
	public String editCliente(ModelMap model, @RequestParam(name = "id", required = false) int id) {
		Cliente cliente = clienteDao.getClienteById(id);
		model.put("clienteIns", cliente);
		return "edit-clienti";
	}
}
