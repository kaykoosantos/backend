package br.unibh.sdm.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = VeiculoTest.DynamoDBConfig.class)
public class VeiculoTest {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @BeforeAll
    public static void setUp() {
        // Configuração de inicialização antes de todos os testes, se necessário
    }

    @AfterAll
    public static void tearDown() {
        // Limpeza ou fechamento após todos os testes, se necessário
    }

    @Test
    public void testSaveAndLoadVeiculo() {
        // Cria uma instância de Veiculo
        Veiculo veiculo = new Veiculo("ABC1234", "Marca", "Modelo", "vermelho");

        // Salva o Veiculo no DynamoDB
        dynamoDBMapper.save(veiculo);

        // Carrega o Veiculo do DynamoDB usando a placa como chave hash
        Veiculo loadedVeiculo = dynamoDBMapper.load(Veiculo.class, veiculo.getPlaca());

        // Verifica se o Veiculo foi carregado corretamente
        assertNotNull(loadedVeiculo);
        assertEquals("Marca", loadedVeiculo.getMarca());
        assertEquals("Modelo", loadedVeiculo.getModelo());
        assertEquals(2024, loadedVeiculo.getCor());
    }

    // Configuração do DynamoDB para o Spring Boot
    static class DynamoDBConfig {

        
        @BeforeAll
        public static void setUp() {
            // Configurações de inicialização do DynamoDB, se necessário
        }

        @AfterAll
        public static void tearDown() {
            // Limpeza ou fechamento do DynamoDB após os testes, se necessário
        }

        @Bean
        public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB) {
            return new DynamoDBMapper(amazonDynamoDB);
        }
    }
}
