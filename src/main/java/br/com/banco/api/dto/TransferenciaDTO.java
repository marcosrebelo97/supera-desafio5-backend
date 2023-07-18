package br.com.banco.api.dto;

import br.com.banco.domain.model.Conta;
import br.com.banco.domain.model.TipoTransferencia;
import br.com.banco.domain.model.Transferencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaDTO {

    private Long id;
    private LocalDateTime dataTransferencia;
    private Double valor;
    private TipoTransferencia tipoTransferencia;
    private String nomeOperadorTransacao;

    private Conta conta;
    public void Conta(Conta idConta){
    }

    public TransferenciaDTO(Transferencia transferencia){
        BeanUtils.copyProperties(transferencia, this);
    }
}
