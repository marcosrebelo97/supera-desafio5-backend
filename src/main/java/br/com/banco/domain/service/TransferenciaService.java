package br.com.banco.domain.service;
import br.com.banco.domain.exception.NotFoundException;
import br.com.banco.domain.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.banco.domain.model.Transferencia;
import java.util.List;

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

    public List<Transferencia> buscarTransferencias(){
        List<Transferencia> transferencias = transferenciaRepository.findAll();
        if(transferencias.isEmpty()){
            throw new NotFoundException("Não foram encontradas transferências.");
        }
        return transferencias;
    }
    
    /*public List<Transferencia> buscarTransferenciaOperador(String nome){
        List<Transferencia> transferencias = transferenciaRepository.findAllByOperadorTransacao(nome);
        if(transferencias.isEmpty()){
            throw new NotFoundException("Este operador não possui transações.");
        }
        return transferencias;
    }*/
}
