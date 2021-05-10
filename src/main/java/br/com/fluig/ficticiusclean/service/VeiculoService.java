package br.com.fluig.ficticiusclean.service;

import br.com.fluig.ficticiusclean.controller.veiculo.dto.VeiculoMapper;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.request.VeiculoCreateRequestDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.VeiculoCreateResponseDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.VeiculoResponseDTO;
import br.com.fluig.ficticiusclean.exception.VeiculoNaoEncontradoException;
import br.com.fluig.ficticiusclean.model.Veiculo;
import br.com.fluig.ficticiusclean.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    VeiculoMapper veiculoMapper;

    public List<VeiculoResponseDTO> findAll(){
        return veiculoRepository.findAll()
                .stream()
                .map(veiculoMapper::veiculoToVeiculoResponseDTO)
                .collect(Collectors.toList());
    }

    public VeiculoResponseDTO create(VeiculoCreateRequestDTO veiculoCreateRequestDTO) {
        Veiculo veiculo = veiculoMapper.veiculoCreateRequestDTO2Veiculo(veiculoCreateRequestDTO);
        Veiculo saved = this.veiculoRepository.save(veiculo);
        return veiculoMapper.veiculoToVeiculoResponseDTO(saved);
    }

    public Veiculo findById(Long id){
        return veiculoRepository.findById(id)
                .orElseThrow(VeiculoNaoEncontradoException::new);
    }

    public Veiculo replace(Veiculo veiculo, Long id){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        if (veiculoOptional.isPresent()){
            Veiculo saved = veiculoOptional.get();
            saved.setNome(veiculo.getNome());
            saved.setMarca(veiculo.getMarca());
            saved.setModelo(veiculo.getModelo());
            saved.setConsumoMedioCidade(veiculo.getConsumoMedioCidade());
            saved.setConsumoMedioRodovia(veiculo.getConsumoMedioRodovia());
            saved.setDataFabricacao(veiculo.getDataFabricacao());
            return veiculoRepository.save(saved);
        } else {
            throw new VeiculoNaoEncontradoException();
        }
    }

    public Veiculo update(Veiculo veiculo, Long id){
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);
        if (veiculoOptional.isPresent()){
            Veiculo saved = veiculoOptional.get();
            saved.setNome(veiculo.getNome());
            saved.setMarca(veiculo.getMarca());
            saved.setModelo(veiculo.getModelo());
            saved.setConsumoMedioCidade(veiculo.getConsumoMedioCidade());
            saved.setConsumoMedioRodovia(veiculo.getConsumoMedioRodovia());
            saved.setDataFabricacao(veiculo.getDataFabricacao());
            return veiculoRepository.save(saved);
        } else {
            throw new VeiculoNaoEncontradoException();
        }

    }

}
