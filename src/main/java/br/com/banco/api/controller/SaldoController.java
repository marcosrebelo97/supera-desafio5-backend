package br.com.banco.api.controller;

import br.com.banco.domain.service.SaldoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/saldo")
public class SaldoController {

    @Autowired
    private final SaldoService saldoService;
}
