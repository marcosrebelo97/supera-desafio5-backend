package br.com.banco.api.dto;

import br.com.banco.domain.model.TipoTransferencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private Long idConta;
}
