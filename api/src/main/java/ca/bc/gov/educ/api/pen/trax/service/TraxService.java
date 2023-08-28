package ca.bc.gov.educ.api.pen.trax.service;

import ca.bc.gov.educ.api.pen.trax.exception.EntityNotFoundException;
import ca.bc.gov.educ.api.pen.trax.model.*;
import ca.bc.gov.educ.api.pen.trax.repository.*;
import ca.bc.gov.educ.api.pen.trax.struct.v1.TotalElements;
import lombok.Getter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
public class TraxService {
  private static final String STUDNO_ATTRIBUTE = "studNo";
  private static final String MINCODE_ATTRIBUTE = "mincode";

  @Getter(PRIVATE)
  private final StudentRepository studentRepository;

  @Getter(PRIVATE)
  private final StudXcrseRepository studXcrseRepository;

  @Getter(PRIVATE)
  private final ProvExamRepository provExamRepository;

  @Getter(PRIVATE)
  private final StudGradAssmtRepository studGradAssmtRepository;

  @Getter(PRIVATE)
  private final TabSchoolRepository tabSchoolRepository;

  /**
   * Instantiates a new Trax service.
   *
   * @param studentRepository  Student repository
   */
  @Autowired
  public TraxService(StudentRepository studentRepository, StudXcrseRepository studXcrseRepository, ProvExamRepository provExamRepository,
                     StudGradAssmtRepository studGradAssmtRepository, TabSchoolRepository tabSchoolRepository) {
    this.studentRepository = studentRepository;
    this.studXcrseRepository = studXcrseRepository;
    this.provExamRepository = provExamRepository;
    this.studGradAssmtRepository = studGradAssmtRepository;
    this.tabSchoolRepository = tabSchoolRepository;
  }

  /**
   * Search for StudentEntity by studNo
   *
   * @param studNo the unique studNo for a given student.
   * @return the Student entity if found.
   */
  public StudentEntity retrieveStudentByStudNo(String studNo) {
    Optional<StudentEntity> result = getStudentRepository().findById(studNo);

    if (result.isPresent()) {
      return result.get();
    } else {
      throw new EntityNotFoundException(StudentEntity.class, STUDNO_ATTRIBUTE, studNo);
    }
  }

  public TotalElements countStudXcrsesByStudNo(final String studNo) {
    TotalElements totalElements = new TotalElements();
    val result = getStudXcrseRepository().countAllByStudXcrseIdStudNo(studNo);
    totalElements.setTotalElements(result);
    return totalElements;
  }

  public TotalElements countProvExamsByStudNo(final String studNo) {
    TotalElements totalElements = new TotalElements();
    val result = getProvExamRepository().countAllByProvExamIdStudNo(studNo);
    totalElements.setTotalElements(result);
    return totalElements;
  }

  public TotalElements countStudGradAssmtsByStudNo(final String studNo) {
    TotalElements totalElements = new TotalElements();
    val result = getStudGradAssmtRepository().countAllByStudGradAssmtIdStudNo(studNo);
    totalElements.setTotalElements(result);
    return totalElements;
  }

  /**
   * Search for TabSchoolEntity by mincode
   *
   * @param mincode the unique mincode for a given school.
   * @return the TabSchool entity if found.
   */
  public TabSchoolEntity retrieveTabSchoolByMincode(String mincode) {
    Optional<TabSchoolEntity> result = getTabSchoolRepository().findById(mincode);

    if (result.isPresent()) {
      return result.get();
    } else {
      throw new EntityNotFoundException(TabSchoolEntity.class, MINCODE_ATTRIBUTE, mincode);
    }
  }
}
