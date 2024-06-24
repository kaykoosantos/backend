package br.unibh.sdm.persistencia;

import java.util.List;
import java.util.UUID;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.entidades.Pessoa;

@EnableScan
public interface PessoaRepository extends CrudRepository<Pessoa, UUID> {
    
	List<Pessoa> findByNome(String nome);
	
}
