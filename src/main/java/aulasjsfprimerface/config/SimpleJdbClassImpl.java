package aulasjsfprimerface.config;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SimpleJdbClassImpl extends SimpleJdbcCall implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private SimpleJdbClassImpl(DataSource dataSource) {
		super(dataSource);
	}
			
}