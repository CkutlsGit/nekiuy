package com.nekiuy.app;

import com.nekiuy.app.model.People;
import com.nekiuy.app.model.Regiment;
import com.nekiuy.app.repository.RegimentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

    @Bean
    public CommandLineRunner dataLoad(RegimentRepository regimentRepository) {
        return args -> {
            List<People> people = new ArrayList<>();
            Regiment regiment = new Regiment(0, 42, "полк 42 арта", people);

            people.add(new People(0, "Иванов иван иваныч", 42, "штурмовик", regiment));
            regiment.setPeople(people);

            regimentRepository.save(regiment);
        };
    }
}
