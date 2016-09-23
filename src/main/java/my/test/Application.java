package my.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableJpaRepositories("my.test")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Application {

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = SpringApplication.run(new Class[]{Application.class}, args);
     }

	@Bean
	protected PermissionEvaluator myPermissionEvaluator() {
		return new MyPermissionEvaluator();
	}

}
