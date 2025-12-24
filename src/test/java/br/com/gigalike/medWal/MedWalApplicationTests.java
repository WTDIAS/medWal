package br.com.gigalike.medWal;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = TestDotenvInitializer.class)
class MedWalApplicationTests {

	@Test
	void contextLoads() {

	}

}
