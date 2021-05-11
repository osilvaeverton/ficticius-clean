package br.com.fluig.ficticiusclean.service;

import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.PrevisaoDeGastosResponseDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.VeiculoMapper;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.request.VeiculoCreateRequestDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.VeiculoResponseDTO;
import br.com.fluig.ficticiusclean.model.Veiculo;
import br.com.fluig.ficticiusclean.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
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
                .map(veiculoMapper::veiculo2VeiculoResponseDTO)
                .collect(Collectors.toList());
    }

    public VeiculoResponseDTO create(VeiculoCreateRequestDTO veiculoCreateRequestDTO) {
        Veiculo veiculo = veiculoMapper.veiculoCreateRequestDTO2Veiculo(veiculoCreateRequestDTO);
        Veiculo saved = this.veiculoRepository.save(veiculo);
        return veiculoMapper.veiculo2VeiculoResponseDTO(saved);
    }

    public List<PrevisaoDeGastosResponseDTO> previsaoDeGastos(BigDecimal precoGasolina, Double kmPercorridoCidade, Double kmPercorridoRodovia) {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos
                .stream()
                .map(veiculo -> calculaConsumo(precoGasolina, kmPercorridoCidade, kmPercorridoRodovia, veiculo))
                .sorted(Comparator.comparing(PrevisaoDeGastosResponseDTO::getValorGastoComCombustivel))
                .collect(Collectors.toList());
    }

    private PrevisaoDeGastosResponseDTO calculaConsumo(BigDecimal precoGasolina, Double kmPercorridoCidade, Double kmPercorridoRodovia, Veiculo veiculo) {
        Double combustivelGastoRodovia = kmPercorridoRodovia / veiculo.getConsumoMedioRodovia();
        Double combustivelGastoCidade = kmPercorridoCidade / veiculo.getConsumoMedioCidade();

        Double totalGasto = combustivelGastoRodovia + combustivelGastoCidade;
        BigDecimal valorTotalCombustivel = precoGasolina.multiply(BigDecimal.valueOf(totalGasto))
                                                            .setScale(2, RoundingMode.HALF_EVEN);

        return PrevisaoDeGastosResponseDTO.builder()
                    .nome(veiculo.getNome())
                    .marca(veiculo.getMarca())
                    .modelo(veiculo.getModelo())
                    .ano(veiculo.getDataFabricacao())
                    .combustivelGasto(Double.valueOf(Math.round(totalGasto)))
                    .valorGastoComCombustivel(valorTotalCombustivel)
                .build();
    }
}
