package br.com.banco.domain.service;

import br.com.banco.domain.exceptionhandler.ProductNotFoundException;
import br.com.banco.domain.model.Transferencia;
import br.com.banco.domain.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Transactional(readOnly = true)
    public Transferencia findById (Long idConta){
        Optional<Transferencia> transferencia = transferenciaRepository.findById(idConta);
        return transferencia.orElseThrow(() -> new ProductNotFoundException());

    }
}
