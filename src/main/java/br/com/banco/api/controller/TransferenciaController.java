package br.com.banco.api.controller;

import br.com.banco.domain.dto.TransferenciaDTO;
import br.com.banco.domain.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaDTO>> listarTransferencias(){
        List<TransferenciaDTO> transferencias = transferenciaService.buscarTransferencias();
        return ResponseEntity.ok().body(transferencias);
    }

    @GetMapping(value = "/operador/{nome}")
    public ResponseEntity<List<Transferencia>> buscarTransferenciaOperador(@PathVariable String nome){
        List<Transferencia> transferencias = transferenciaService.buscarTransferenciaOperador(nome);
        return ResponseEntity.ok().body(transferencias);
    }

}
