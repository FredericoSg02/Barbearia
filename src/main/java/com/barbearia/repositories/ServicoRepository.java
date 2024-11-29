package com.barbearia.repositories;

import com.barbearia.domains.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    Optional<Servico> findByAgendamento(Integer idAgendadamento);
}