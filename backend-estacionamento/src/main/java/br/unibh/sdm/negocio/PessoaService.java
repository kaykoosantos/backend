package br.unibh.sdm.negocio;

import br.unibh.sdm.entidades.Pessoa;
import br.unibh.sdm.persistencia.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa criarPessoa(String nome, String cpf, String rg, String telefone) {
        Pessoa pessoa = new Pessoa(nome, cpf, rg, telefone);
        return pessoaRepository.save(pessoa);
    }

    public void excluirPessoa(UUID id) {
        pessoaRepository.deleteById(id);
    }

    public Optional<Pessoa> buscarPessoaPorId(UUID id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> buscarPessoaPorNome(String nome) {
        return pessoaRepository.findByNome(nome);
    }
}
