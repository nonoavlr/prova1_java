package com.resistence.war.repository;

import com.resistence.war.domain.RebeldeDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RebeldeRepository extends JpaRepository<RebeldeDomain, Long> {
}
