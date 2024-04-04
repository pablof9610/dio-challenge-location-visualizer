package dio.project.challenge.locationvisualizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LocationVisualizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationVisualizerApplication.class, args);
	}

}
