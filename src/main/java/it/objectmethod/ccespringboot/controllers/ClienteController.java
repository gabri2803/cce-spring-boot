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
	public String editPageCliente(ModelMap model, @RequestParam(name = "id", required = false) int id,
			@RequestParam(name = "reg", required = false) String nomeRegione,
			@RequestParam(name = "provinciaNascita", required = false) String nomeProvincia) {
		Cliente cliente = null;
		List<String> regioni = null;
		List<String> province = null;
		List<String> comuni = null;
		String regione = null;
		if (id > -1) {
			cliente = clienteDao.getClienteById(id);
			if (cliente.getProvinciaNascita() != null) {
				regione = comuneDao.getRegioneByProvincia(cliente.getProvinciaNascita());
				province = comuneDao.getAllProvince(regione);
				comuni = comuneDao.getAllComuni(cliente.getProvinciaNascita());
			}
			model.put("regioneSel", regione);
		}
		if (nomeRegione != null) {
			province = comuneDao.getAllProvince(nomeRegione);
			model.put("regioneSel", nomeRegione);
		}
		if (nomeProvincia != null) {
			comuni = comuneDao.getAllComuni(nomeProvincia);
		}
		regioni = comuneDao.getaAllRegioni();
		model.put("id", id);
		model.put("listaComuni", comuni);
		model.put("listaProvince", province);
		model.put("listaRegioni", regioni);
		model.put("clienteIns", cliente);
		return "edit-clienti";
	}

	@RequestMapping("/edit-cliente")
	public String editCliente(ModelMap model, @RequestParam(name = "id", required = false) String idNew,
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
			@RequestParam(name = "tipoIns", required = false) String tipo,
			@RequestParam(name = "condizioniPagamentoIns", required = false) String condPag,
			@RequestParam(name = "noteIns", required = false) String note,
			@RequestParam(name = "emailIns", required = false) String email) {
		Cliente nuovoCliente = new Cliente();
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
		nuovoCliente.setCodiceZona(codZona);
		nuovoCliente.setCodiceCliente(codCli);
		nuovoCliente.setStato(stato);
		nuovoCliente.setCondizioniPagamento(condPag);
		nuovoCliente.setNote(note);
		nuovoCliente.setEmail(email);
		if (idNew != "") {
			int id = Integer.parseInt(idNew);
			nuovoCliente.setId(id);
			clienteDao.putCliente(nuovoCliente);
		} else {
			clienteDao.postCliente(nuovoCliente);
		}
		listaClienti(model);
		return "list-clients";
	}
}
