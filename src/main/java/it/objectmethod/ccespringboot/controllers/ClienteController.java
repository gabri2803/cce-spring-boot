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
	public String editPageCliente(ModelMap model, @RequestParam(name = "id", required = false) int idIns,
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
		List<String> regioni = comuneDao.getAllRegioni();
		Cliente cliente = null;
		if (idIns > -1) {
			cliente = clienteDao.getClienteById(idIns);
			provNasc = cliente.getProvinciaNascita();
			comNasc = cliente.getComuneNascita();
			model.addAttribute("id", idIns);
		} else {
			cliente = clienteDao.salvaVariabili(nome, cognome, codFisc, statoNasc, provNasc, comNasc, dataNasc, sesso,
					telef, cell, ragSoc, iva, bancaAp, abi, cab, codZona, codCli, stato, tipoIns, condPag, note, email);
		}
		model.addAttribute("sessoM", "M");
		model.addAttribute("sessoF", "F");
		model.addAttribute("tipoPg", "PG");
		model.addAttribute("tipoPs", "PS");
		model.addAttribute("provinciaSel", provNasc);
		model.addAttribute("comuneSel", comNasc);
		model.addAttribute("listaRegioni", regioni);
		model.addAttribute("clienteIns", cliente);
		return "edit-clienti";
	}

	@RequestMapping("/edit-cliente")
	public String editCliente(ModelMap model, @RequestParam(name = "id", required = false) String idClient,
			@RequestParam(name = "regioneSel", required = false) String nomeRegione,
			@RequestParam(name = "nomeIns", required = false) String nome,
			@RequestParam(name = "cognomeIns", required = false) String cognome,
			@RequestParam(name = "codiceFiscaleIns", required = false) String codFisc,
			@RequestParam(name = "statoNascitaIns", required = false) String statoNasc,
			@RequestParam(name = "provinciaNascitaSel", required = false) String provNasc,
			@RequestParam(name = "comuneNascitaSel", required = false) String comNasc,
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
		Cliente nuovoCliente = new Cliente();
		String message = "Salvato";
		nuovoCliente.setNome(nome);
		nuovoCliente.setCognome(cognome);
		nuovoCliente.setCodiceFiscale(codFisc);
		nuovoCliente.setStatoNascita(statoNasc);
		nuovoCliente.setProvinciaNascita(provNasc);
		nuovoCliente.setComuneNascita(comNasc);
		nuovoCliente.setDataNascita(dataNasc);
		nuovoCliente.setSesso(sesso);
		nuovoCliente.setTelefono(telef);
		nuovoCliente.setCellulare(cell);
		nuovoCliente.setRagioneSociale(ragSoc);
		nuovoCliente.setPartitaIva(iva);
		nuovoCliente.setBancaAppoggio(bancaAp);
		nuovoCliente.setAbi(abi);
		nuovoCliente.setCab(cab);
		nuovoCliente.setTipo(tipoIns);
		nuovoCliente.setCodiceZona(codZona);
		nuovoCliente.setCodiceCliente(codCli);
		nuovoCliente.setStato(stato);
		nuovoCliente.setCondizioniPagamento(condPag);
		nuovoCliente.setNote(note);
		nuovoCliente.setEmail(email);
		if (idClient != "") {
			int id = Integer.parseInt(idClient);
			nuovoCliente.setId(id);
			clienteDao.putCliente(nuovoCliente);
		} else {
			clienteDao.postCliente(nuovoCliente);
		}
		model.addAttribute("message", message);
		listaClienti(model);
		return "list-clients";
	}

	@RequestMapping("/delete-client")
	public String deleteClient(ModelMap model, @RequestParam(name = "id") int id) {
		String message = "Cliente eliminato";
		clienteDao.deleteCliente(id);
		listaClienti(model);
		model.addAttribute("message", message);
		return "list-clients";
	}
}
