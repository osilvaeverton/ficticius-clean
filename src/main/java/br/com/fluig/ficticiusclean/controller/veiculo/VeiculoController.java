package br.com.fluig.ficticiusclean.controller.veiculo;

import br.com.fluig.ficticiusclean.controller.veiculo.dto.request.VeiculoCreateRequestDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.PrevisaoDeGastosResponseDTO;
import br.com.fluig.ficticiusclean.controller.veiculo.dto.response.VeiculoResponseDTO;
import br.com.fluig.ficticiusclean.exception.VeiculoNaoEncontradoException;
import br.com.fluig.ficticiusclean.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping(path = "/veiculos")
@RestController
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VeiculoResponseDTO>> list(){
        return new ResponseEntity<>(this.veiculoService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VeiculoResponseDTO> create(@RequestBody VeiculoCreateRequestDTO veiculoCreateRequestDTO){
        return new ResponseEntity<>(this.veiculoService.create(veiculoCreateRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/previsao",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrevisaoDeGastosResponseDTO>> previsaoDeGastos(
            @RequestParam BigDecimal precoGasolina,
            @RequestParam Double kmPercorridoCidade,
            @RequestParam Double kmPercorridoRodovia){
        return new ResponseEntity<>(this.veiculoService.previsaoDeGastos(precoGasolina, kmPercorridoCidade, kmPercorridoRodovia), HttpStatus.OK);
    }

}
