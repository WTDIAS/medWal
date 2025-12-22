package br.com.gigalike.medWal;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedWalApplication {
	public static void main(String[] args) {
        // Carrega o arquivo .env da raiz
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Configura as propriedades do sistema para o Spring ler
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(MedWalApplication.class, args);
	}
}
