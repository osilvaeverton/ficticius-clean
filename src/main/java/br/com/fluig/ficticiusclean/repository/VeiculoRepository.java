package br.com.fluig.ficticiusclean.repository;

import br.com.fluig.ficticiusclean.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
