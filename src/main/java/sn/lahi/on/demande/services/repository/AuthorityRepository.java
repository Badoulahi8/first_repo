package sn.lahi.on.demande.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.lahi.on.demande.services.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
