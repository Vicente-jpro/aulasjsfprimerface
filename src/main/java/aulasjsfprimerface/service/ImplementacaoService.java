package aulasjsfprimerface.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import aulasjsfprimerface.config.HibernateConexao;
import aulasjsfprimerface.config.JdbcTemplateImpl;
import aulasjsfprimerface.config.SimpleJdbcInsertImpl;
import aulasjsfprimerface.config.SimpleJdbcTemplateImpl;
import aulasjsfprimerface.interf.InterfaceCrud;

@Component
@Transactional
public class ImplementacaoService<T> implements InterfaceCrud<T>{

	private static final long serialVersionUID = 1L;

	private static SessionFactory sessionFactory = HibernateConexao.getSessionFactory();
	
	@Autowired
	private JdbcTemplateImpl JdbcTemplateImpl;
	
	@Autowired
	private SimpleJdbcTemplateImpl simpleJdbcTemplateImpl;
	
	@Autowired
	private SimpleJdbcInsertImpl simpleJdbcInsertImpl;
	
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public JdbcTemplateImpl getJdbcTemplateImpl() {
		return JdbcTemplateImpl;
	}

	public SimpleJdbcTemplateImpl getSimpleJdbcTemplateImpl() {
		return simpleJdbcTemplateImpl;
	}

	public SimpleJdbcInsertImpl getSimpleJdbcInsertImpl() {
		return simpleJdbcInsertImpl;
	}

	@Override
	public T salvar(T object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T persistir(T object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T atualizar(T object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(T obeject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findList(Class<T> object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional findById(Class<T> entidade, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllBy(String str) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limparSessionHibernate() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void evict(T object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Session getSession() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getListSQLDinamica(String str) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleJdbcInsert getSimpleJdbcInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long totalRegistro(String table) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAllByDinamicQuery(String query, int iniciaNovoRegistro, int maximoResultado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Iniciar a transação caso a sessão não estiver ativa
	private void validarTransacao() {
		if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
			sessionFactory.getCurrentSession().beginTransaction();
		}
	}
	
	private void CommitProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().commit();
	} 
	
	private void rolbackProcessoAjax() {
		sessionFactory.getCurrentSession().beginTransaction().rollback();
	}

	private void validarSessaoFactory() {
		if (sessionFactory.getCurrentSession() == null)
		sessionFactory = HibernateConexao.getSessionFactory();
	}

}
