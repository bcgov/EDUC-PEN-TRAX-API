package ca.bc.gov.educ.api.pen.trax.struct.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The type ProvExam.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProvExam implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  @Size(max = 10)
  @NotNull(message = "studNo can not be null.")
  private String studNo;

  @Size(max = 5)
  @NotNull(message = "crseCode can not be null.")
  private String crseCode;

  @Size(max = 3)
  @NotNull(message = "crseLevel can not be null.")
  private String crseLevel;

  @Size(max = 6)
  @NotNull(message = "crseSession can not be null.")
  private String crseSession;

  @Size(max = 2)
  private String predLg;

  @Size(max = 1)
  private String provIbFlag;

  @Size(max = 1)
  private String adjudFlag;

  @Size(max = 1)
  private String preprintFlag;

  @Size(max = 1)
  private String wroteFlag;

  private Long provSchoolPct;

  @Size(max = 1)
  private String provSpecCase;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal rawScore;

  private Long provExamPct;

  private Long provFinalPct;

  @Size(max = 2)
  private String finalLg;

  @Size(max = 8)
  private String localCrseId;

  @Size(max = 9)
  private String localCrsePer;

  @Size(max = 2)
  private String localCrseSec;

  @Size(max = 1)
  private String localCrseSem;

  @Size(max = 8)
  private String mincodeExam;

  private Long bestSchoolPct;

  private Long bestExamPct;

  @Size(max = 8)
  private String mincodeHome;

  private Long predPct;

  private Long numCredits;

  @Size(max = 2)
  private String studyType;

  @Size(max = 1)
  private String usedForGrad;

  @Size(max = 1)
  private String crseType;

  @Size(max = 1)
  private String fndCredits;

  private Long scholSms;

  @Size(max = 1)
  private String scholSpecCase;

  @Size(max = 6)
  private String bestExamSession;

  @Size(max = 1)
  private String eFileDeleteFlag;

  private Long provPrebumpFinalPct;

  @Size(max = 2)
  private String formCode;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal mcTotal;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal oeTotal;

  @JsonFormat(shape=JsonFormat.Shape.STRING)
  private BigDecimal irtScore;

  @Size(max = 2)
  private String examSourceCode;

  @Size(max = 1)
  private String toWriteFlag;

  @Size(max = 1)
  private String examPrintCode;

  @Size(max = 1)
  private String blendOptional;

  @Size(max = 5)
  private String metLitNumReqt;

}
