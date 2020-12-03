package ca.bc.gov.educ.api.pen.trax.struct.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The type Assessment.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudGradAssmt implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  @Size(max = 10)
  @NotNull(message = "studNo can not be null.")
  private String studNo;

  @Size(max = 5)
  @NotNull(message = "assmtCode can not be null.")
  private String assmtCode;

  @Size(max = 6)
  @NotNull(message = "assmtSession can not be null.")
  private String assmtSession;

  @Size(max = 2)
  private String formCode;

  @Size(max = 20)
  private String localAssmtId;

  @Size(max = 8)
  private String mincodeHome;

  @Size(max = 8)
  private String mincodeAssmt;

  @Size(max = 1)
  private String specialCase;

  @Size(max = 1)
  private String wroteFlag;

  private Long gradReqtMet;

  @Size(max = 1)
  private String exceededWritesFlag;

  private Long percentComplete;

  private Long assmtProficiencyScore;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal rawScore;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal irtScore;

  @Size(max = 1)
  private String assmtPrintCode;

  @Size(max = 1)
  private String preprintFlag;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal mcTotal;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal oeTotal;

  @Size(max = 1)
  private String adaptedAssmt;

  @Size(max = 6)
  private String markingSession;

}
