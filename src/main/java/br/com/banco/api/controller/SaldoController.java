package br.com.banco.api.controller;

import br.com.banco.domain.service.SaldoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/saldo")
public class SaldoController {

    @Autowired
    private final SaldoService saldoService;

    @GetMapping(value = "/conta/{idConta}")
    public ResponseEntity<BigDecimal> calcularSaldoTotalConta(@PathVariable Long idConta) {
        BigDecimal saldoTotal = saldoService.calcularSaldoTotalConta(idConta);
        return ResponseEntity.ok(saldoTotal);
    }

}
