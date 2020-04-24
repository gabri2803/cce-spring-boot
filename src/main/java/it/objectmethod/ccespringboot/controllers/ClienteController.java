package it.objectmethod.ccespringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.ccespringboot.dao.IClienteDao;
import it.objectmethod.ccespringboot.dao.IComuneDao;
import it.objectmethod.ccespringboot.model.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;
	@Autowired
	private IComuneDao comuneDao;

	@RequestMapping("/lista-clienti")
	public String listaClienti(ModelMap model) {
		List<Cliente> clienti = clienteDao.getAllClienti();
		model.put("clientiList", clienti);
		return "list-clients";
	}

	@RequestMapping("/edit-page")
	public String editCliente(ModelMap model, @RequestParam(name = "id", required = false) int id,
			@RequestParam(name = "reg", required = false) String nomeRegione,
			@RequestParam(name = "prov", required = false) String nomeProvincia) {
		Cliente cliente = null;
		List<String> regioni = null;
		List<String> province = null;
		List<String> comuni = null;
		String regione = null;
		if (id > -1) {
			cliente = clienteDao.getClienteById(id);
		}
		if (cliente != null) {
			regione = comuneDao.getRegioneByProvincia(cliente.getProvinciaNascita());
			province = comuneDao.getAllProvince(regione);
			comuni = comuneDao.getAllComuni(cliente.getProvinciaNascita());
			model.put("regioneSel", regione);
		} else {
			if (nomeRegione != null) {
				province = comuneDao.getAllProvince(nomeRegione);
				model.put("regioneSel", nomeRegione);
			}
			if (nomeProvincia != null) {
				comuni = comuneDao.getAllComuni(nomeProvincia);
			}
		}
		regioni = comuneDao.getaAllRegioni();
		model.put("id", id);
		model.put("listaComuni", comuni);
		model.put("listaProvince", province);
		model.put("listaRegioni", regioni);
		model.put("clienteIns", cliente);
		return "edit-clienti";
	}
}
