package br.com.banco.domain.service;
import br.com.banco.domain.dto.TransferenciaDTO;
import br.com.banco.domain.exception.NotFoundException;
import br.com.banco.domain.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.domain.model.Transferencia;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    @Autowired
    private final TransferenciaRepository transferenciaRepository;

    public List<Transferencia> buscarTransferenciaIdConta (Long idConta){
        List<Transferencia> transferencias = transferenciaRepository.findAllByContaIdConta(idConta);
        if(transferencias.isEmpty()){
            throw new NotFoundException("Está conta não possui transações");
        }
        return transferencias;
    }

    @Transactional(readOnly = true)
    public List<TransferenciaDTO> buscarTransferencias(){
        return transferenciaRepository.findAll().stream().map(transferencia -> new TransferenciaDTO(transferencia)).collect(Collectors.toList());
    }
    
    public List<Transferencia> buscarTransferenciaOperador(String nome){
        List<Transferencia> transferencias = transferenciaRepository.findAllByNomeOperadorTransacao(nome);
        if(transferencias.isEmpty()){
            throw new NotFoundException("Este operador não possui transações.");
        }
        return transferencias;
    }

    public List<Transferencia> buscarTransferenciasPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return transferenciaRepository.findAllByDataTransferenciaBetween(inicio, fim);
    }
}
