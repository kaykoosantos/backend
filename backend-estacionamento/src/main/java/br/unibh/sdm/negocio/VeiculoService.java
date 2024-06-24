package br.unibh.sdm.negocio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.unibh.sdm.entidades.Veiculo;
import br.unibh.sdm.persistencia.VeiculoRepository;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> consultarVeiculoPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

    public void excluirVeiculo(Veiculo veiculo) {
        veiculoRepository.delete(veiculo);
    }
}
