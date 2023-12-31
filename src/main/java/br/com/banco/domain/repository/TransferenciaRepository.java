package br.com.banco.domain.repository;

import br.com.banco.domain.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    List<Transferencia> findAllByContaIdConta (Long idConta);
    List<Transferencia> findAllByNomeOperadorTransacao(String nome);
    List<Transferencia> findAllByDataTransferenciaBetween(LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE t.conta.id = :idConta")
    BigDecimal calcularSaldoTotalConta(Long idConta);

    @Query("SELECT COALESCE(SUM(t.valor), 0) FROM Transferencia t")
    BigDecimal calcularSaldoTotal();

    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE LOWER(t.nomeOperadorTransacao) LIKE CONCAT('%', LOWER(:nomeOperadorTransacao), '%')")
    BigDecimal calcularSaldoTotalPorOperador(@Param("nomeOperadorTransacao") String nomeOperadorTransacao);

    @Query("SELECT SUM(t.valor) FROM Transferencia t WHERE t.dataTransferencia BETWEEN :inicio AND :fim")
    BigDecimal calcularSaldoTotalPeriodo(LocalDateTime inicio, LocalDateTime fim);
}
