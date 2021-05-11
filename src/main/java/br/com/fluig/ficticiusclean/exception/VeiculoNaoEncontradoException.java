package br.com.fluig.ficticiusclean.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Veículo não encontrado")
public class VeiculoNaoEncontradoException extends Exception {
}
