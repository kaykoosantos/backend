package br.unibh.sdm.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import br.unibh.sdm.persistencia.PessoaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PropertyPlaceholderAutoConfiguration.class, PessoaTest.DynamoDBConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class PessoaTest {

    private static Logger LOGGER = LoggerFactory.getLogger(PessoaTest.class);

    @Configuration
	@EnableDynamoDBRepositories(basePackageClasses = PessoaRepository.class)
	public static class DynamoDBConfig {

		@Value("${amazon.aws.accesskey}")
		private String amazonAWSAccessKey;

		@Value("${amazon.aws.secretkey}")
		private String amazonAWSSecretKey;

		public AWSCredentialsProvider amazonAWSCredentialsProvider() {
			return new AWSStaticCredentialsProvider(amazonAWSCredentials());
		}

		@Bean
		public AWSCredentials amazonAWSCredentials() {
			return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
		}

		@Bean
		public AmazonDynamoDB amazonDynamoDB() {
			return AmazonDynamoDBClientBuilder.standard().withCredentials(amazonAWSCredentialsProvider())
					.withRegion(Regions.US_EAST_1).build();
		}
	}

    @Autowired
	private PessoaRepository repository;

	@Test
	public void teste1Criacao() throws ParseException {
		LOGGER.info("Cadastrado nova pessoa...");
         Pessoa pessoa1 = new Pessoa("Kailane","12345678956","12586749","33999947756");
         repository.save(pessoa1);

         Pessoa pessoa2 = new Pessoa("Vitor","45675395126","13524827","319999856247");
         repository.save(pessoa2);


                  LOGGER.info("Pesquisado todos");
		Iterable<Pessoa> lista = repository.findAll();
		assertNotNull(lista.iterator());
		for (Pessoa criptomoeda : lista) {
			LOGGER.info(criptomoeda.toString());
		}

        LOGGER.info("Pesquisado uma pessoa");
		List<Pessoa> result = repository.findByNome("Kailane");
		assertEquals(result.size(), 1);
		assertEquals(result.get(0).getCpf(), "12345678956");
		LOGGER.info("Encontrado: {}", result.get(0));
    }
    
    @Test
	public void teste2Exclusao() throws ParseException {
		LOGGER.info("Excluindo cadastro...");
        Pessoa pessoa1 = new Pessoa("Kailane","12345678956","12586749","33999947756");
        repository.delete(pessoa1);

        Pessoa pessoa2 = new Pessoa("Vitor","45675395126","13524827","319999856247");
         repository.delete(pessoa2);
}
}

