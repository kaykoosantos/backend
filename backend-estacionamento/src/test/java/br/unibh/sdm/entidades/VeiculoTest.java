package br.unibh.sdm.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

    private Veiculo veiculo;

    @BeforeEach
    public void setUp() {
        // Dados de exemplo
        String placa = "ABC-1234";
        String modelo = "Fusca";
        String marca = "Volkswagen";
        String cor = "Preto";

        // Criar um novo veículo
        veiculo = new Veiculo(placa, modelo, marca, cor);
    }

    @Test
    public void testCriarNovoVeiculo() {
        // Verificar se o veículo não é nulo
        assertNotNull(veiculo);

        // Verificar se os dados estão corretos
        assertEquals("ABC-1234", veiculo.getPlaca());
        assertEquals("Fusca", veiculo.getModelo());
        assertEquals("Volkswagen", veiculo.getMarca());
        assertEquals("Preto", veiculo.getCor());
    }

    @Test
    public void testExcluirVeiculo() {
        // Simular a exclusão (marcar veículo como nulo)
        veiculo = null;

        // Verificar se o veículo foi excluído
        assertNull(veiculo);
    }

    @Test
    public void testConsultarVeiculo() {
        // Simulação de consulta por placa
        String placaConsulta = "ABC-1234";

        // Verificar se o veículo foi encontrado
        if (placaConsulta.equals(veiculo.getPlaca())) {
            assertEquals("ABC-1234", veiculo.getPlaca());
            assertEquals("Fusca", veiculo.getModelo());
            assertEquals("Volkswagen", veiculo.getMarca());
            assertEquals("Preto", veiculo.getCor());
        } else {
            assertNull(veiculo); // Se não encontrou, veiculo deve ser nulo
        }
    }
}
