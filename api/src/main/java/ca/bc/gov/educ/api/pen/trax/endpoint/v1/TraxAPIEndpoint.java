package ca.bc.gov.educ.api.pen.trax.endpoint.v1;

import ca.bc.gov.educ.api.pen.trax.struct.v1.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * The interface Trax api endpoint.
 */
@RequestMapping("/api/v1")
@OpenAPIDefinition(info = @Info(title = "API to TRAX CRU.", description = "This API is related to TRAX data.", version = "1"),
  security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_PEN_TRAX"})})
public interface TraxAPIEndpoint {
  /**
   * Get student by studNo.
   *
   * @param studNo the studNo
   * @return the Student
   */
  @GetMapping("/students")
  @PreAuthorize("hasAuthority('SCOPE_READ_PEN_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "404", description = "NOT FOUND")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get Student entity.", description = "Endpoint to get Student entity by studNo.")
  @Schema(name = "Student", implementation = Student.class)
  Student getStudentByStudNo(@RequestParam("studNo")  String studNo);

  /**
   * The following 3 endpoints are not paginated. The URL was kept to be compatible with EDUC-STUDENT-ADMIN. Pagination with RDB broke during the springboot upgrade to 3.0.2.
   * So the team decided to pivot to this solution.
   *
   * @param studNo the studNo
   * @return the TotalElements count
   */
  @GetMapping("/stud-xcrses/paginated")
  @PreAuthorize("hasAuthority('SCOPE_READ_PEN_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR.")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get StudXcrse count", description = "Endpoint to get StudXcrse count by StudNo.")
  TotalElements countStudXcrsesByStudNo(@RequestParam("studNo") String studNo);

  @GetMapping("/prov-exams/paginated")
  @PreAuthorize("hasAuthority('SCOPE_READ_PEN_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR.")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get ProvExam count.", description = "Endpoint to get ProvExam count by StudNo.")
  TotalElements countProvExamsByStudNo(@RequestParam("studNo") String studNo);

  @GetMapping("/stud-grad-assmts/paginated")
  @PreAuthorize("hasAuthority('SCOPE_READ_PEN_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR.")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get StudGradAssmt count.", description = "Endpoint to get StudGradAssmt count by StudNo.")
  TotalElements countStudGradAssmtsByStudNo(@RequestParam("studNo") String studNo);

  /**
   * Get school by mincode.
   *
   * @param mincode the studNo
   * @return the TabSchool
   */
  @GetMapping("/tab-schools")
  @PreAuthorize("hasAuthority('SCOPE_READ_PEN_TRAX')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "404", description = "NOT FOUND")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get TabSchool entity.", description = "Endpoint to get TabSchool entity by mincode.")
  @Schema(name = "TabSchool", implementation = TabSchool.class)
  TabSchool getTabSchoolByMincode(@RequestParam("mincode")  String mincode);
}
