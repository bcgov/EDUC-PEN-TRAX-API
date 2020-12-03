package ca.bc.gov.educ.api.pen.trax.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Non-examinable course entity.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUD_XCRSE")
public class StudXcrseEntity {
  @EmbeddedId
  private StudXcrseId studXcrseId;

  @Column(name = "PRED_LG")
  private String predLg;

  @Column(name = "FINAL_LG")
  private String finalLg;

  @Column(name = "PRED_PCT")
  private Long predPct;

  @Column(name = "FINAL_PCT")
  private Long finalPct;

  @Column(name = "NUM_CREDITS")
  private Long numCredits;

  @Column(name = "STUDY_TYPE")
  private String studyType;

  @Column(name = "USED_FOR_GRAD")
  private String usedForGrad;

  @Column(name = "RELATED_CRSE")
  private String relatedCrse;

  @Column(name = "RELATED_LEVEL")
  private String relatedLevel;

  @Column(name = "COURSE_DESC")
  private String courseDesc;

  @Column(name = "CRSE_TYPE")
  private String crseType;

  @Column(name = "GRAD_REQT_TYPE")
  private String gradReqtType;

  @Column(name = "FND_CREDITS")
  private String fndCredits;

}
