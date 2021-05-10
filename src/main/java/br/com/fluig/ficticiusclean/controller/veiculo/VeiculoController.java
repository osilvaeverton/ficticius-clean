package br.com.fluig.ficticiusclean.controller.veiculo;

import br.com.fluig.ficticiusclean.controller.veiculo.dto.request.VeiculoCreateRequestDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.VeiculoCreateResponseDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.VeiculoResponseDTO;
import br.com.fluig.ficticiusclean.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(name = "/veiculos")
@RestController
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    public ResponseEntity<List<VeiculoResponseDTO>> list(){
        return new ResponseEntity<>(this.veiculoService.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<VeiculoResponseDTO> create(VeiculoCreateRequestDTO veiculoCreateRequestDTO){
        return new ResponseEntity<>(this.veiculoService.create(veiculoCreateRequestDTO), HttpStatus.CREATED);
    }

}
