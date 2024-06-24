package br.unibh.sdm.persistencia;

import java.util.List;
import java.util.UUID;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.entidades.Veiculo;

@EnableScan
public interface VeiculoRepository extends CrudRepository<Veiculo, UUID> {
    
	List<Veiculo> findByNome(String nome);
}
