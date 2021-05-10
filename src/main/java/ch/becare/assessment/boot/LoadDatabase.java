package ch.becare.assessment.boot;

import ch.becare.assessment.dao.UserRepository;
import ch.becare.assessment.dao.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("it@skay.ch","Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new User("sales@skay.ch","Frodo Baggins", "thief")));
        };
    }
}
