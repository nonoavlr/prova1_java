package com.resistence.war.repository;

import com.resistence.war.domain.LocalizacaoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalizacaoRepository extends JpaRepository<LocalizacaoDomain, Long> {

    Optional<LocalizacaoDomain> findByRebeldeDomain(Long id);
}
