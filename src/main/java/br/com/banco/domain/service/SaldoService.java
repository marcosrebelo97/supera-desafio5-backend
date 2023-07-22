package br.com.banco.domain.service;

import br.com.banco.domain.exception.NotFoundException;
import br.com.banco.domain.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

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

    public BigDecimal calcularSaldoTotalPorOperador(String nomeOperadorTransacao){
        BigDecimal saldoTotalOperador = transferenciaRepository.calcularSaldoTotalPorOperador(nomeOperadorTransacao);
        if(saldoTotalOperador == null){
            throw new NotFoundException("Este operador não possui transações cadastradas");
        }
        return saldoTotalOperador.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcularSaldoTotalPeriodo(LocalDateTime inicio, LocalDateTime fim){
        BigDecimal saldoTotalPeriodo = transferenciaRepository.calcularSaldoTotalPeriodo(inicio, fim);
        if(saldoTotalPeriodo == null){
            throw new NotFoundException("O cálculo total para o período fornecido falhou.");
        }
        return saldoTotalPeriodo.setScale(2, RoundingMode.HALF_UP);
    }

}
