package ca.bc.gov.educ.api.pen.trax.repository;

import ca.bc.gov.educ.api.pen.trax.model.StudXcrseEntity;
import ca.bc.gov.educ.api.pen.trax.model.StudXcrseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface StudXcrse repository.
 */
@Repository
public interface StudXcrseRepository extends JpaRepository<StudXcrseEntity, StudXcrseId> {
  Integer countAllByStudXcrseIdStudNo(String studNo);
}
