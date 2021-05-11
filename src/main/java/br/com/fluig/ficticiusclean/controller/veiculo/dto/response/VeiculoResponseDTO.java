package br.com.fluig.ficticiusclean.controller.veiculo.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VeiculoResponseDTO {

    private Long id;
    private String nome;
    private String marca;
    private String modelo;
    private LocalDate dataFabricacao;
    private Double consumoMedioCidade;
    private Double consumoMedioRodovia;

}
