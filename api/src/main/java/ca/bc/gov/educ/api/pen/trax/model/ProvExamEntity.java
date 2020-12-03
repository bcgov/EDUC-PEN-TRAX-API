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
 * The type Provincially examinable course entity.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROV_EXAM")
public class ProvExamEntity {
  @EmbeddedId
  private ProvExamId provExamId;

  @Column(name = "PRED_LG")
  private String predLg;

  @Column(name = "PROV_IB_FLAG")
  private String provIbFlag;

  @Column(name = "ADJUD_FLAG")
  private String adjudFlag;

  @Column(name = "PREPRINT_FLAG")
  private String preprintFlag;

  @Column(name = "WROTE_FLAG")
  private String wroteFlag;

  @Column(name = "PROV_SCHOOL_PCT")
  private Long provSchoolPct;

  @Column(name = "PROV_SPEC_CASE")
  private String provSpecCase;

  @Column(name = "RAW_SCORE", precision = 4, scale = 1)
  private BigDecimal rawScore;

  @Column(name = "PROV_EXAM_PCT")
  private Long provExamPct;

  @Column(name = "PROV_FINAL_PCT")
  private Long provFinalPct;

  @Column(name = "FINAL_LG")
  private String finalLg;

  @Column(name = "LOCAL_CRSE_ID")
  private String localCrseId;

  @Column(name = "LOCAL_CRSE_PER")
  private String localCrsePer;

  @Column(name = "LOCAL_CRSE_SEC")
  private String localCrseSec;

  @Column(name = "LOCAL_CRSE_SEM")
  private String localCrseSem;

  @Column(name = "MINCODE_EXAM")
  private String mincodeExam;

  @Column(name = "BEST_SCHOOL_PCT")
  private Long bestSchoolPct;

  @Column(name = "BEST_EXAM_PCT")
  private Long bestExamPct;

  @Column(name = "MINCODE_HOME")
  private String mincodeHome;

  @Column(name = "PRED_PCT")
  private Long predPct;

  @Column(name = "NUM_CREDITS")
  private Long numCredits;

  @Column(name = "STUDY_TYPE")
  private String studyType;

  @Column(name = "USED_FOR_GRAD")
  private String usedForGrad;

  @Column(name = "CRSE_TYPE")
  private String crseType;

  @Column(name = "FND_CREDITS")
  private String fndCredits;

  @Column(name = "SCHOL_SMS")
  private Long scholSms;

  @Column(name = "SCHOL_SPEC_CASE")
  private String scholSpecCase;

  @Column(name = "BEST_EXAM_SESSION")
  private String bestExamSession;

  @Column(name = "E_FILE_DELETE_FLAG")
  private String eFileDeleteFlag;

  @Column(name = "PROV_PREBUMP_FINAL_PCT")
  private Long provPrebumpFinalPct;

  @Column(name = "FORM_CODE")
  private String formCode;

  @Column(name = "MC_TOTAL", precision = 4, scale = 1)
  private BigDecimal mcTotal;

  @Column(name = "OE_TOTAL", precision = 4, scale = 1)
  private BigDecimal oeTotal;

  @Column(name = "IRT_SCORE", precision = 9, scale = 4)
  private BigDecimal irtScore;

  @Column(name = "EXAM_SOURCE_CODE")
  private String examSourceCode;

  @Column(name = "TO_WRITE_FLAG")
  private String toWriteFlag;

  @Column(name = "EXAM_PRINT_CODE")
  private String examPrintCode;

  @Column(name = "BLEND_OPTIONAL")
  private String blendOptional;

  @Column(name = "MET_LIT_NUM_REQT")
  private String metLitNumReqt;

}
