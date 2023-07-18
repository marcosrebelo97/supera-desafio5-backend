package br.com.banco.api.controller;

import br.com.banco.api.dto.TransferenciaDTO;
import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.TransferenciaRepository;
import br.com.banco.domain.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaController {
    @Autowired
    private TransferenciaService transferenciaService;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @GetMapping(value = "/{idConta}")
    public ResponseEntity<Transferencia> findById(@PathVariable Long idConta){
            Transferencia transferencia = transferenciaService.findById(idConta);
            return ResponseEntity.ok().body(transferencia);
    }
}
