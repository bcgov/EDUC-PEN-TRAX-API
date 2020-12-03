package ca.bc.gov.educ.api.pen.trax.repository;

import ca.bc.gov.educ.api.pen.trax.model.ProvExamEntity;
import ca.bc.gov.educ.api.pen.trax.model.ProvExamId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface ProvExam repository.
 */
@Repository
public interface ProvExamRepository extends JpaRepository<ProvExamEntity, ProvExamId> {
  Page<ProvExamEntity> findByProvExamIdStudNo(String studNo, Pageable pageable);
}
