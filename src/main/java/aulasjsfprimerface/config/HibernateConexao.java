package aulasjsfprimerface.config;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

}
