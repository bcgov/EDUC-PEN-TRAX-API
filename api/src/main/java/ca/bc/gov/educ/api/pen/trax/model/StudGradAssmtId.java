package ca.bc.gov.educ.api.pen.trax.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * The type Assessment Id.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudGradAssmtId implements Serializable {
  @Column(name = "STUD_NO", nullable = false)
  private String studNo;

  @Column(name = "ASSMT_CODE", nullable = false)
  private String assmtCode;

  @Column(name = "ASSMT_SESSION", nullable = false)
  private String assmtSession;
}
