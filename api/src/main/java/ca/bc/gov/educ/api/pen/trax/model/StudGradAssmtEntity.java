package ca.bc.gov.educ.api.pen.trax.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * The type Assessment entity.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUD_GRAD_ASSMT")
public class StudGradAssmtEntity {
  @EmbeddedId
  private StudGradAssmtId studGradAssmtId;

  @Column(name = "FORM_CODE")
  private String formCode;

  @Column(name = "LOCAL_ASSMT_ID")
  private String localAssmtId;

  @Column(name = "MINCODE_HOME")
  private String mincodeHome;

  @Column(name = "MINCODE_ASSMT")
  private String mincodeAssmt;

  @Column(name = "SPECIAL_CASE")
  private String specialCase;

  @Column(name = "WROTE_FLAG")
  private String wroteFlag;

  @Column(name = "GRAD_REQT_MET")
  private Long gradReqtMet;

  @Column(name = "EXCEEDED_WRITES_FLAG")
  private String exceededWritesFlag;

  @Column(name = "PERCENT_COMPLETE")
  private Long percentComplete;

  @Column(name = "ASSMT_PROFICIENCY_SCORE")
  private Long assmtProficiencyScore;

  @Column(name = "RAW_SCORE", precision = 4, scale = 1)
  private BigDecimal rawScore;

  @Column(name = "IRT_SCORE", precision = 9, scale = 4)
  private BigDecimal irtScore;

  @Column(name = "ASSMT_PRINT_CODE")
  private String assmtPrintCode;

  @Column(name = "PREPRINT_FLAG")
  private String preprintFlag;

  @Column(name = "MC_TOTAL", precision = 4, scale = 1)
  private BigDecimal mcTotal;

  @Column(name = "OE_TOTAL", precision = 4, scale = 1)
  private BigDecimal oeTotal;

  @Column(name = "ADAPTED_ASSMT")
  private String adaptedAssmt;

  @Column(name = "MARKING_SESSION")
  private String markingSession;

}
