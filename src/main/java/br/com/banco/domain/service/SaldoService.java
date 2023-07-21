package br.com.banco.domain.service;

import br.com.banco.domain.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaldoService {

    @Autowired
    private final TransferenciaRepository transferenciaRepository;


}
