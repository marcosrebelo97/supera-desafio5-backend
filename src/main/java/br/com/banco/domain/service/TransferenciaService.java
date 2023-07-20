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
}
