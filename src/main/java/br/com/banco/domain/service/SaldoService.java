package br.com.banco.domain.service;

import br.com.banco.domain.exception.NotFoundException;
import br.com.banco.domain.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class SaldoService {

    @Autowired
    private final TransferenciaRepository transferenciaRepository;

    public BigDecimal calcularSaldoTotalConta(Long idConta) {
        BigDecimal saldoTotal = transferenciaRepository.calcularSaldoTotalConta(idConta);
        if (saldoTotal == null) {
            throw new NotFoundException("Não foi possível exibir o saldo. Verifique os dados da conta.");
        }
        return saldoTotal.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularSaldoTotal(){
        return transferenciaRepository.calcularSaldoTotal();
    }


}
