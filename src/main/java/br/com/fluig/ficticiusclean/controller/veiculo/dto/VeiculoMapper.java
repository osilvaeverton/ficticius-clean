package br.com.fluig.ficticiusclean.controller.veiculo.dto;

import br.com.fluig.ficticiusclean.controller.veiculo.dto.request.VeiculoCreateRequestDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.VeiculoResponseDTO;
import br.com.fluig.ficticiusclean.model.Veiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoResponseDTO veiculo2VeiculoResponseDTO(Veiculo veiculo);

    Veiculo veiculoCreateRequestDTO2Veiculo(VeiculoCreateRequestDTO veiculoCreateRequestDTO);

}
