package org.jhipster.com.repository;

import org.jhipster.com.domain.School;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the School entity.
 */
@SuppressWarnings("unused")
public interface SchoolRepository extends JpaRepository<School,Long> {

}
