package realtime.videocall.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "realtime.videocall.app.entities")
public class AyaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AyaneApplication.class, args);
		System.out.println("hello world!");
	}

}
