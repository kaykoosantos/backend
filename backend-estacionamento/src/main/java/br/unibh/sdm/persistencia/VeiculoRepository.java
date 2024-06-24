package br.unibh.sdm.persistencia;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.entidades.Veiculo;

@EnableScan
public interface VeiculoRepository extends CrudRepository<Veiculo, String> {
    
    Optional<Veiculo> findByPlaca(String placa);
    
}
