package br.unibh.sdm.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        // Dados de exemplo
        String nome = "Lais";
        String cpf = "123.456.789-00";
        String rg = "18.652.963";
        String telefone = "33999947756";

        // Criar uma nova pessoa
        pessoa = new Pessoa(nome, cpf, rg, telefone);
    }

    @Test
    public void testCriarNovaPessoa() {
        // Verificar se a pessoa não é nula
        assertNotNull(pessoa);

        // Verificar se os dados estão corretos
        assertEquals("Lais", pessoa.getNome());
        assertEquals("123.456.789-00", pessoa.getCpf());
        assertEquals("18.652.963", pessoa.getRg());
        assertEquals("33999947756", pessoa.getTelefone());
    }

    @Test
    public void testConsultarPessoa() {
        // Simulação de consulta por cpf
        String cpfConsulta = "123.456.789-00";

        // Verificar se a pessoa foi encontrada
        if (cpfConsulta.equals(pessoa.getCpf())) {
            assertEquals("Lais", pessoa.getNome());
            assertEquals("123.456.789-00", pessoa.getCpf());
            assertEquals("18.652.963", pessoa.getRg());
            assertEquals("33999947756", pessoa.getTelefone());
        } else {
            assertNull(pessoa); // Se não encontrou, pessoa deve ser nula
        }
    }
}
