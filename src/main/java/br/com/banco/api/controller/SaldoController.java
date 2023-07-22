package br.com.banco.api.controller;

import br.com.banco.domain.service.SaldoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    @GetMapping(value = "/total")
    public ResponseEntity<BigDecimal> calcularSaldoTotal(){
        BigDecimal saldoTotal = saldoService.calcularSaldoTotal();
        return ResponseEntity.ok(saldoTotal);
    }

    @GetMapping(value = "/total/{nomeOperadorTransacao}")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPorOperador (@PathVariable String nomeOperadorTransacao){
        BigDecimal saldoTotal = saldoService.calcularSaldoTotalPorOperador(nomeOperadorTransacao);
        return ResponseEntity.ok(saldoTotal);
    }

    @GetMapping(value = "/totalPeriodo", produces = "application/json")
    public ResponseEntity<BigDecimal> calcularSaldoTotalPeriodo(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fim) {

        LocalDateTime dataInicio = inicio.atStartOfDay();
        LocalDateTime dataFim = fim.atTime(LocalTime.MAX);
        BigDecimal saldoTotal = saldoService.calcularSaldoTotalPeriodo(dataInicio, dataFim);
        return ResponseEntity.ok(saldoTotal);
    }

}
