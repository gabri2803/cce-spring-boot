package it.objectmethod.ccespringboot.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.ccespringboot.dao.IComuneDao;

@Controller
public class ComuneController {

	@Autowired
	private IComuneDao comuneDao;

	@GetMapping("/drop-menu")
	public String dropMenu(ModelMap model, @RequestParam(name = "regioneSel", required = false) String nomeRegione,
			@RequestParam(name = "provinciaNascitaIns", required = false) String nomeProvincia,
			@RequestParam(name = "comuneNascitaIns", required = false) String comune, HttpSession session) {
		List<String> regioni = null;
		List<String> province = null;
		List<String> comuni = null;
		regioni = comuneDao.getAllRegioni();
		if (nomeRegione != null) {
			province = comuneDao.getAllProvince(nomeRegione);
			model.put("regioneSel", nomeRegione);
		}
		if (nomeProvincia != null) {
			comuni = comuneDao.getAllComuni(nomeProvincia);
		}
		model.put("provinciaNascitaSel", nomeProvincia);
		model.put("comuneNascitaSel", comune);
		model.put("listaComuni", comuni);
		model.put("listaProvince", province);
		model.put("listaRegioni", regioni);
		return "edit-clienti";
	}
}
