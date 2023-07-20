package br.com.banco.domain.dto;

import br.com.banco.domain.model.Conta;
import br.com.banco.domain.model.Transferencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferenciaDTO {

    private LocalDateTime dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransferencia;

    private Conta conta;
    public void Conta(Conta conta){
    }

    public TransferenciaDTO(Transferencia transferencia){
        dataTransferencia = transferencia.getDataTransferencia();
        valor = transferencia.getValor();
        tipo = transferencia.getTipo();
        nomeOperadorTransferencia = transferencia.getNomeOperadorTransacao();
    }
}
