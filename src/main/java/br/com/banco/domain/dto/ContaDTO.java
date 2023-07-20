package br.com.banco.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.banco.domain.model.Conta;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    String nomeResponsavel;

    public ContaDTO(Conta conta){
        nomeResponsavel = conta.getNomeResponsavel();
    }
}
