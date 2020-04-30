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
public class ComuneController {

	@Autowired
	private IComuneDao comuneDao;
	@Autowired
	private IClienteDao clienteDao;

	@RequestMapping("/drop-menu")
	public String dropMenu(ModelMap model, @RequestParam(name = "id", required = false) String idCliente,
			@RequestParam(name = "regioneSel", required = false) String nomeRegione,
			@RequestParam(name = "nomeIns", required = false) String nome,
			@RequestParam(name = "cognomeIns", required = false) String cognome,
			@RequestParam(name = "codiceFiscaleIns", required = false) String codFisc,
			@RequestParam(name = "statoNascitaIns", required = false) String statoNasc,
			@RequestParam(name = "provinciaNascitaIns", required = false) String provNasc,
			@RequestParam(name = "comuneNascitaIns", required = false) String comNasc,
			@RequestParam(name = "dataNascitaIns", required = false) String dataNasc,
			@RequestParam(name = "sessoIns", required = false) String sesso,
			@RequestParam(name = "telefonoIns", required = false) String telef,
			@RequestParam(name = "cellulareIns", required = false) String cell,
			@RequestParam(name = "ragioneSocialeIns", required = false) String ragSoc,
			@RequestParam(name = "partitaIvaIns", required = false) String iva,
			@RequestParam(name = "bancaAppoggioIns", required = false) String bancaAp,
			@RequestParam(name = "abiIns", required = false) String abi,
			@RequestParam(name = "cabIns", required = false) String cab,
			@RequestParam(name = "codiceZonaIns", required = false) String codZona,
			@RequestParam(name = "codiceClienteIns", required = false) String codCli,
			@RequestParam(name = "statoIns", required = false) String stato,
			@RequestParam(name = "tipoIns", required = false) String tipoIns,
			@RequestParam(name = "condizioniPagamentoIns", required = false) String condPag,
			@RequestParam(name = "noteIns", required = false) String note,
			@RequestParam(name = "emailIns", required = false) String email) {
		Cliente cliente = null;
		if (idCliente != null && idCliente != "") {
			int id = Integer.parseInt(idCliente);
			cliente = clienteDao.getClienteById(id);
			model.addAttribute("id", idCliente);
		} else {
			cliente = clienteDao.salvaVariabili(nome, cognome, codFisc, statoNasc, provNasc, comNasc, dataNasc, sesso,
					telef, cell, ragSoc, iva, bancaAp, abi, cab, codZona, codCli, stato, tipoIns, condPag, note, email);
		}
		prepareDropMenu(model, nomeRegione, provNasc);
		model.addAttribute("sessoM", "M");
		model.addAttribute("sessoF", "F");
		model.addAttribute("tipoPg", "PG");
		model.addAttribute("tipoPs", "PS");
		model.addAttribute("comuneSel", comNasc);
		model.addAttribute("clienteIns", cliente);
		return "edit-clienti";
	}

	public void prepareDropMenu(ModelMap model, String nomeRegione, String provNasc) {
		List<String> regioni = comuneDao.getAllRegioni();
		List<String> province = comuneDao.getAllProvince(nomeRegione);
		List<String> comuni = comuneDao.getAllComuni(provNasc);
		model.addAttribute("regioneIns", nomeRegione);
		model.addAttribute("provinciaSel", provNasc);
		model.addAttribute("listaComuni", comuni);
		model.addAttribute("listaProvince", province);
		model.addAttribute("listaRegioni", regioni);
	}
}
