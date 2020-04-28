package it.objectmethod.ccespringboot.dao;

import java.util.List;

public interface IComuneDao {
	public List<String> getAllRegioni();

	public List<String> getAllProvince(String nomeRegione);

	public List<String> getAllComuni(String nomeProvincia);

	public String getRegioneByProvincia(String nomeProv);
}
