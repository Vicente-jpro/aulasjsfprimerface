package aulasjsfprimerface.config;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;

public class HibernateConexao implements Serializable{

	private static final long serialVersionUID = 1L;
	private static String JAVA_COMP_ENV_JDBC_DATASOURSE = "java:/comp/env/jdbc/postgres";
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * Responsavel por ler arquivo de configuração hibernate.cfg.xml
	 * @return SessionFactory
	 * */
	private static SessionFactory buildSessionFactory() {
		try {
			
			if(sessionFactory == null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			
			return sessionFactory;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("Erro ao criar conexão SessionFactory");
		}
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * Retorna a sessão do SessionFactory
	 * @return Session
	 * */
	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	/**
	 * Abre uma nova sessão no SessionFactory
	 * @return Session
	 * */
	public static Session openSession() {
		if(sessionFactory == null) {
			buildSessionFactory();
		}
		return sessionFactory.openSession() ;
	}
	
	/**
	 * Obter a conexão do provedor de conexõesconfigurado
	 * @return Connection SQL
	 * @throws SQLException
	 * */
	public static Connection getConnectionProvider() throws SQLException{
		return ((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection(); 
		
	}
	
	/**
	 * @return Connection no InitalContext JAVA_COMP_ENV_JDBC_DATASOURSE
	 * @throws Exception
	 * */

	public static Connection getConnection() throws Exception{
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup( JAVA_COMP_ENV_JDBC_DATASOURSE );

		if ( ds == null ) {
		   throw new Exception("Data source not found!");
		}
		
		return ds.getConnection();
	}
	
}
