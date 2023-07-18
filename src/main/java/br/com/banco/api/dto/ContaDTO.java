package br.com.banco.api.dto;

import br.com.banco.domain.model.Conta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDTO {

    private Long idConta;
    private String nomeResponsavel;

    public ContaDTO(Conta conta){
        idConta = conta.getIdConta();
        nomeResponsavel = conta.getNomeResponsavel();
    }


}
