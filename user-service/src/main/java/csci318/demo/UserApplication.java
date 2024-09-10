package csci318.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import csci318.demo.model.Users.Customer;
import csci318.demo.repository.CustomerRepository;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner loadDatabase(CustomerRepository customerRepository) throws Exception {
		return args -> {
			Customer entry = new Customer();
			entry.setId(1L);
			entry.setName("Ranko");
			customerRepository.save(entry);
			System.out.println(customerRepository.findById(1L).orElseThrow().getName());
			Customer entry1 = new Customer();
			entry1.setId(2L);
			entry1.setName("Jesus");
			customerRepository.save(entry1);
			System.out.println(customerRepository.findById(2L).orElseThrow().getName());
		};
	}

}
