package ca.bc.gov.educ.api.pen.trax.controller.v1;

import ca.bc.gov.educ.api.pen.trax.endpoint.v1.TraxAPIEndpoint;
import ca.bc.gov.educ.api.pen.trax.exception.TraxAPIRuntimeException;
import ca.bc.gov.educ.api.pen.trax.mapper.v1.TraxMapper;
import ca.bc.gov.educ.api.pen.trax.service.TraxService;
import ca.bc.gov.educ.api.pen.trax.struct.v1.*;
import ca.bc.gov.educ.api.pen.trax.util.RequestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


/**
 * The type Trax api controller.
 */
@RestController
@EnableResourceServer
@Slf4j
public class TraxAPIController implements TraxAPIEndpoint {
  @Getter(AccessLevel.PRIVATE)
  private final TraxService service;

  /**
   * The constant mapper.
   */
  private static final TraxMapper mapper = TraxMapper.mapper;

  /**
   * Instantiates a new Trax api controller.
   *
   * @param service    the service
   */
  @Autowired
  public TraxAPIController(TraxService service) {
    this.service = service;
  }

  @Override
  public Student getStudentByStudNo(String studNo) {
    return mapper.toStructure(getService().retrieveStudentByStudNo(studNo));
  }

  @Override
  public CompletableFuture<Page<StudXcrse>> findStudXcrsesByStudNo(String studNo, Integer pageNumber, Integer pageSize, String sortCriteriaJson) {
    final List<Sort.Order> sorts = getSortCriteria(sortCriteriaJson);
    return getService().findStudXcrsesByStudNo(pageNumber, pageSize, sorts, studNo).thenApplyAsync(entities -> entities.map(mapper::toStructure));
  }

  @Override
  public CompletableFuture<Page<ProvExam>> findProvExamsByStudNo(String studNo, Integer pageNumber, Integer pageSize, String sortCriteriaJson) {
    final List<Sort.Order> sorts = getSortCriteria(sortCriteriaJson);
    return getService().findProvExamsByStudNo(pageNumber, pageSize, sorts, studNo).thenApplyAsync(entities -> entities.map(mapper::toStructure));
  }

  @Override
  public CompletableFuture<Page<StudGradAssmt>> findStudGradAssmtsByStudNo(String studNo, Integer pageNumber, Integer pageSize, String sortCriteriaJson) {
    final List<Sort.Order> sorts = getSortCriteria(sortCriteriaJson);
    return getService().findStudGradAssmtsByStudNo(pageNumber, pageSize, sorts, studNo).thenApplyAsync(entities -> entities.map(mapper::toStructure));
  }

  @Override
  public TabSchool getTabSchoolByMincode(String mincode) {
    return mapper.toStructure(getService().retrieveTabSchoolByMincode(mincode));
  }

  private List<Sort.Order> getSortCriteria(String sortCriteriaJson) {
    final ObjectMapper objectMapper = new ObjectMapper();
    final List<Sort.Order> sorts = new ArrayList<>();
    try {
      RequestUtil.getSortCriteria(sortCriteriaJson, objectMapper, sorts);
    } catch (JsonProcessingException e) {
      throw new TraxAPIRuntimeException(e.getMessage());
    }
    return sorts;
  }

}
