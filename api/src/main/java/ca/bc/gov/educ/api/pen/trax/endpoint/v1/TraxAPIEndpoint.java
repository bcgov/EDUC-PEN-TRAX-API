package ca.bc.gov.educ.api.pen.trax.endpoint.v1;

import ca.bc.gov.educ.api.pen.trax.struct.v1.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


/**
 * The interface Trax api endpoint.
 */
@RequestMapping("/api/v1")
@OpenAPIDefinition(info = @Info(title = "API to TRAX CRU.", description = "This API is related to TRAX data.", version = "1"),
  security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_TRAX"})})
public interface TraxAPIEndpoint {
  /**
   * Get student by studNo.
   *
   * @param studNo the studNo
   * @return the Student
   */
  @GetMapping("/students")
  @PreAuthorize("#oauth2.hasScope('READ_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "404", description = "NOT FOUND")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get Student entity.", description = "Endpoint to get Student entity by studNo.")
  @Schema(name = "Student", implementation = Student.class)
  Student getStudentByStudNo(@RequestParam("studNo")  String studNo);

  @GetMapping("/stud-xcrses/paginated")
  @Async
  @PreAuthorize("#oauth2.hasScope('READ_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR.")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get StudXcrse entities, with sort and pagination.", description = "Endpoint to get StudXcrse entities by StudNo.")
  CompletableFuture<Page<StudXcrse>> findStudXcrsesByStudNo(@RequestParam("studNo") String studNo,
                                                            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                            @RequestParam(name = "sort", defaultValue = "") String sortCriteriaJson);

  @GetMapping("/prov-exams/paginated")
  @Async
  @PreAuthorize("#oauth2.hasScope('READ_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR.")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get ProvExam entities, with sort and pagination.", description = "Endpoint to get ProvExam entities by StudNo.")
  CompletableFuture<Page<ProvExam>> findProvExamsByStudNo(@RequestParam("studNo") String studNo,
                                                          @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                          @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                          @RequestParam(name = "sort", defaultValue = "") String sortCriteriaJson);

  @GetMapping("/stud-grad-assmts/paginated")
  @Async
  @PreAuthorize("#oauth2.hasScope('READ_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR.")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get StudGradAssmt entities, with sort and pagination.", description = "Endpoint to get StudGradAssmt entities by StudNo.")
  CompletableFuture<Page<StudGradAssmt>> findStudGradAssmtsByStudNo(@RequestParam("studNo") String studNo,
                                                                    @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(name = "sort", defaultValue = "") String sortCriteriaJson);

  /**
   * Get school by mincode.
   *
   * @param mincode the studNo
   * @return the TabSchool
   */
  @GetMapping("/tab-schools")
  @PreAuthorize("#oauth2.hasScope('READ_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "404", description = "NOT FOUND")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get TabSchool entity.", description = "Endpoint to get TabSchool entity by mincode.")
  @Schema(name = "TabSchool", implementation = TabSchool.class)
  TabSchool getTabSchoolByMincode(@RequestParam("mincode")  String mincode);
}
