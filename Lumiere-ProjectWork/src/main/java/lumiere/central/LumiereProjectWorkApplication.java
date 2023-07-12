package lumiere.central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@SpringBootApplication
@EnableTransactionManagement
public class LumiereProjectWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(LumiereProjectWorkApplication.class, args);
	}

	@Bean // Need to expose SessionFactory to be able to work with BLOBs
    public SessionFactory sessionFactory(SessionFactoryImplementor hemf) {
        return hemf.getSessionFactory();
    }
}
