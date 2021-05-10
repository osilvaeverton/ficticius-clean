package br.com.fluig.ficticiusclean.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String marca;
    private String modelo;
    private LocalDate dataFabricacao;
    private Double consumoMedioCidade;
    private Double consumoMedioRodovia;

}
