package aulasjsfprimerface.interf;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

public interface InterfaceCrud<T> extends Serializable{

	T salvar(T object) throws Exception; 

	T persistir(T object) throws Exception;
	
	T atualizar(T object) throws Exception;
	
	void eliminar(T obeject) throws Exception;
	
	List<T> findList(Class<T> object) throws Exception;
	
	Optional findById(Class<T> entidade, Long id);
	
	List<T> findAllBy(String str) throws Exception;
	
	void limparSessionHibernate() throws Exception;
	
	void evict (T object) throws Exception;
	
	Session getSession() throws Exception;
	
	List<?> getListSQLDinamica(String str) throws Exception;
	
	//JDB do Spring
	
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	Long totalRegistro(String table) throws Exception;
	
	List<T> findAllByDinamicQuery(String query, int iniciaNovoRegistro, int maximoResultado);
	
}
