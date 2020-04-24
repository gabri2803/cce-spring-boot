package it.objectmethod.ccespringboot.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.ccespringboot.dao.IClienteDao;
import it.objectmethod.ccespringboot.mappers.ClienteMapper;
import it.objectmethod.ccespringboot.model.Cliente;

@Service
public class ClienteDaoImpl extends NamedParameterJdbcDaoSupport implements IClienteDao {

	@Autowired
	public ClienteDaoImpl(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<Cliente> getAllClienti() {
		String sql = "SELECT * FROM cliente";
		List<Cliente> clienti = getJdbcTemplate().query(sql, new ClienteMapper());
		return clienti;
	}

	@Override
	public Cliente getClienteById(int id) {
		String sql = "SELECT * FROM cliente WHERE id=?";
		Cliente cliente = getJdbcTemplate().queryForObject(sql, new Object[] { id }, new ClienteMapper());
		return cliente;
	}

}
