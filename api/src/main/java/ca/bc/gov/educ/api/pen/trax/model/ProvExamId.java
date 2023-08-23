package ca.bc.gov.educ.api.pen.trax.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * The type Prov Exam Id.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProvExamId implements Serializable {
  @Column(name = "STUD_NO", nullable = false)
  private String studNo;

  @Column(name = "CRSE_CODE", nullable = false)
  private String crseCode;

  @Column(name = "CRSE_LEVEL", nullable = false)
  private String crseLevel;

  @Column(name = "CRSE_SESSION", nullable = false)
  private String crseSession;
}
