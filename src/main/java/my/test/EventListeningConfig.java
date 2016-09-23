package my.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventListeningConfig {

	@Bean
    public BeforeSaveEventListener beforeSaveEventListener() {
    	return new BeforeSaveEventListener();
    }
}
