package br.com.fluig.ficticiusclean.controller.veiculo.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
public class PrevisaoDeGastosResponseDTO {

    private String nome;
    private String marca;
    private String modelo;
    private LocalDate ano;
    private Double combustivelGasto;
    private BigDecimal valorGastoComCombustivel;

}
