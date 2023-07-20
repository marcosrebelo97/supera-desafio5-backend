package br.com.banco.domain.repository;

import br.com.banco.domain.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    List<Transferencia> findAllByContaIdConta (Long idConta);

    List<Transferencia> findAllByNomeOperadorTransacao(String nome);

    List<Transferencia> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);
}
