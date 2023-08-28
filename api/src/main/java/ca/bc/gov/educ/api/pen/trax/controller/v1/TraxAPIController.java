package ca.bc.gov.educ.api.pen.trax.controller.v1;

import ca.bc.gov.educ.api.pen.trax.endpoint.v1.TraxAPIEndpoint;
import ca.bc.gov.educ.api.pen.trax.mapper.v1.TraxMapper;
import ca.bc.gov.educ.api.pen.trax.service.TraxService;
import ca.bc.gov.educ.api.pen.trax.struct.v1.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Trax api controller.
 */
@RestController
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
  public TotalElements countStudXcrsesByStudNo(String studNo) {
    return getService().countStudXcrsesByStudNo(studNo);
  }

  @Override
  public TotalElements countProvExamsByStudNo(String studNo) {
    return getService().countProvExamsByStudNo(studNo);
  }

  @Override
  public TotalElements countStudGradAssmtsByStudNo(String studNo) {
    return getService().countStudGradAssmtsByStudNo(studNo);
  }

  @Override
  public TabSchool getTabSchoolByMincode(String mincode) {
    return mapper.toStructure(getService().retrieveTabSchoolByMincode(mincode));
  }

}
