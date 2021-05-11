package br.com.fluig.ficticiusclean.controller.veiculo.dto.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class VeiculoCreateRequestDTO {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    private String marca;

    @NotBlank(message = "Campo obrigatório")
    private String modelo;

    @NotNull(message = "Campo obrigatório")
    private LocalDate dataFabricacao;

    @Min(value = 1, message = "Campo obrigatório")
    private Double consumoMedioCidade;

    @Min(value = 1, message = "Campo obrigatório")
    private Double consumoMedioRodovia;

}
