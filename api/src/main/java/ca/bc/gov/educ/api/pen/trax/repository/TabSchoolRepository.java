package ca.bc.gov.educ.api.pen.trax.repository;

import ca.bc.gov.educ.api.pen.trax.model.TabSchoolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface TabSchool repository.
 */
@Repository
public interface TabSchoolRepository extends CrudRepository<TabSchoolEntity, String> {
}
