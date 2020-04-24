package it.objectmethod.ccespringboot.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.ccespringboot.dao.IComuneDao;

@Service
public class ComuneDaoImpl extends NamedParameterJdbcDaoSupport implements IComuneDao {

	@Autowired
	public ComuneDaoImpl(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<String> getaAllRegioni() {
		String sql = "SELECT DISTINCT regione FROM comune";
		List<String> regioni = getJdbcTemplate().queryForList(sql, String.class);
		return regioni;
	}

	@Override
	public List<String> getAllProvince(String nomeRegione) {
		String sql = "SELECT DISTINCT provincia FROM comune WHERE regione=?";
		List<String> province = getJdbcTemplate().queryForList(sql, new Object[] { nomeRegione }, String.class);
		return province;
	}

	@Override
	public List<String> getAllComuni(String nomeProvincia) {
		String sql = "SELECT nome FROM comune WHERE provincia=?";
		List<String> comuni = getJdbcTemplate().queryForList(sql, new Object[] { nomeProvincia }, String.class);
		return comuni;
	}

	@Override
	public String getRegioneByProvincia(String nomeProv) {
		String sql = "SELECT DISTINCT regione FROM comune WHERE provincia = ?";
		String regione = getJdbcTemplate().queryForObject(sql, new Object[] { nomeProv }, String.class);
		return regione;
	}
}
