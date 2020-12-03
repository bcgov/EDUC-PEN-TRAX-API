package ca.bc.gov.educ.api.pen.trax.struct.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * The type StudXcrse.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudXcrse implements Serializable {
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

  @Size(max = 2)
  private String finalLg;

  private Long predPct;

  private Long finalPct;

  private Long numCredits;

  @Size(max = 2)
  private String studyType;

  @Size(max = 1)
  private String usedForGrad;

  @Size(max = 5)
  private String relatedCrse;

  @Size(max = 3)
  private String relatedLevel;

  @Size(max = 40)
  private String courseDesc;

  @Size(max = 1)
  private String crseType;

  @Size(max = 1)
  private String gradReqtType;

  @Size(max = 1)
  private String fndCredits;

}
