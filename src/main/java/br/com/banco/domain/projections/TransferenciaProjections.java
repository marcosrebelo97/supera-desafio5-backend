package br.com.banco.domain.projections;

import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransferenciaProjections {
    String nomeResponsavel();
    LocalDateTime getDataTransferencia();
    BigDecimal getValor();
    String getTipo();
    String getNomeOperadorTransacao();
}
