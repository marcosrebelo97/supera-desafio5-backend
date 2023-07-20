package br.com.banco.api.controller;

import br.com.banco.domain.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.banco.domain.model.Transferencia;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/transferencias")
public class TransferenciaController {

    @Autowired
    private final TransferenciaService transferenciaService;

    @GetMapping(value = "/{idConta}")
    public ResponseEntity<List<Transferencia>> buscarContaTransferencia (@PathVariable Long idConta){
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciaIdConta(idConta);
        return ResponseEntity.ok(transferencias);
    }

}
