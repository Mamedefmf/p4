package br.com.fiap.p4.p4;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PPPRepository extends JpaRepository<PPP, UUID> {
}