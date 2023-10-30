package br.com.fiap.p4.p4.repository;

import java.util.UUID;

import br.com.fiap.p4.p4.entities.PPP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PPPRepository extends JpaRepository<PPP, UUID> {
}
