package com.barbearia.repositories;

import com.barbearia.domains.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
    Optional<Localidade> findByCidade(String cpf);
}