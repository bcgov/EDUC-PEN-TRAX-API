package ca.bc.gov.educ.api.pen.trax.service;

import ca.bc.gov.educ.api.pen.trax.exception.EntityNotFoundException;
import ca.bc.gov.educ.api.pen.trax.model.*;
import ca.bc.gov.educ.api.pen.trax.repository.*;
import lombok.Getter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

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

  /**
   * Search for StudXcrseEntity by studNo
   *
   * @param studNo the unique studNo for a given student.
   * @return the page of StudXcrse entities if found.
   */
  public CompletableFuture<Page<StudXcrseEntity>> findStudXcrsesByStudNo(final Integer pageNumber, final Integer pageSize,
                                                                         final List<Sort.Order> sorts, final String studNo) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sorts));
    try {
      val result = getStudXcrseRepository().findByStudXcrseIdStudNo(studNo, paging);
      return CompletableFuture.completedFuture(result);
    } catch (final Exception ex) {
      throw new CompletionException(ex);
    }
  }

  /**
   * Search for ProvExamEntity by studNo
   *
   * @param studNo the unique studNo for a given student.
   * @return the page of ProvExam entities if found.
   */
  public CompletableFuture<Page<ProvExamEntity>> findProvExamsByStudNo(final Integer pageNumber, final Integer pageSize,
                                                                       final List<Sort.Order> sorts, final String studNo) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sorts));
    try {
      val result = getProvExamRepository().findByProvExamIdStudNo(studNo, paging);
      return CompletableFuture.completedFuture(result);
    } catch (final Exception ex) {
      throw new CompletionException(ex);
    }
  }

  /**
   * Search for StudGradAssmtEntity by studNo
   *
   * @param studNo the unique studNo for a given student.
   * @return the page of StudGradAssmt entities if found.
   */
  public CompletableFuture<Page<StudGradAssmtEntity>> findStudGradAssmtsByStudNo(final Integer pageNumber, final Integer pageSize,
                                                                            final List<Sort.Order> sorts, final String studNo) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sorts));
    try {
      val result = getStudGradAssmtRepository().findByStudGradAssmtIdStudNo(studNo, paging);
      return CompletableFuture.completedFuture(result);
    } catch (final Exception ex) {
      throw new CompletionException(ex);
    }
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
