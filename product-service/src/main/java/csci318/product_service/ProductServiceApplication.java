package csci318.product_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import csci318.product_service.model.Product;
import csci318.product_service.repository.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	@Bean
	public CommandLineRunner loadDatabase(ProductRepository productRepository) throws Exception {
		return args -> {
			Product entry = new Product();
			entry.setName("Apple");
			productRepository.save(entry);
			System.out.println(productRepository.findById(1L).orElseThrow().getName());
			Product entry1 = new Product();
			entry1.setName("Bannana");
			productRepository.save(entry1);
			System.out.println(productRepository.findById(2L).orElseThrow().getName());
		};
	}

}
