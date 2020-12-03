package ca.bc.gov.educ.api.pen.trax.repository;

import ca.bc.gov.educ.api.pen.trax.model.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Student repository.
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, String> {
}
