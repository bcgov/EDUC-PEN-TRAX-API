package ca.bc.gov.educ.api.pen.trax.repository;

import ca.bc.gov.educ.api.pen.trax.model.StudGradAssmtEntity;
import ca.bc.gov.educ.api.pen.trax.model.StudGradAssmtId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface StudGradAssmt repository.
 */
@Repository
public interface StudGradAssmtRepository extends JpaRepository<StudGradAssmtEntity, StudGradAssmtId> {
  Page<StudGradAssmtEntity> findByStudGradAssmtIdStudNo(String studNo, Pageable pageable);
}
