package br.com.banco.domain.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_transferencia")
    private LocalDateTime dataTransferencia;

    private Double valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transferencia")
    private TipoTransferencia tipoTransferencia;

    @Column(name = "nome_operador_transferencia")
    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
    private Conta conta;
}
