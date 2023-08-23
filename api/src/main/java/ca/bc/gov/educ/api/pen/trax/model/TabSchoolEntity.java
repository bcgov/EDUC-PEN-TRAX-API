package ca.bc.gov.educ.api.pen.trax.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The type Tab school entity.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAB_SCHOOL")
public class TabSchoolEntity {
  @Id
  @Column(name = "MINCODE", unique = true, updatable = false)
  private String mincode;

  @Column(name = "SCHL_NAME")
  private String schlName;

  @Column(name = "ADDRESS1")
  private String address1;

  @Column(name = "ADDRESS2")
  private String address2;

  @Column(name = "CITY")
  private String city;

  @Column(name = "PROV_CODE")
  private String provCode;

  @Column(name = "CNTRY_CODE")
  private String cntryCode;

  @Column(name = "POSTAL")
  private String postal;

  @Column(name = "PRINC_NAME")
  private String princName;

  @Column(name = "OPEN_FLAG")
  private String openFlag;

  @Column(name = "SCHL_ETP_SYS")
  private String schlEtpSys;

  @Column(name = "SCHL_IND_TYPE")
  private String schlIndType;

  @Column(name = "SCHL_IND_AFFIL")
  private String schlIndAffil;

  @Column(name = "SCHL_ORG")
  private String schlOrg;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "MINISTRY_CONTACT")
  private String ministryContact;

  @Column(name = "FILLER7")
  private String filler7;

  @Column(name = "XCRIPT_ELIG")
  private String xcriptElig;

  @Column(name = "DOGWOOD_ELIG")
  private String dogwoodElig;

  @Column(name = "MAILER_TYPE")
  private String mailerType;

  @Column(name = "LOOMIS_FLAG")
  private String loomisFlag;

  @Column(name = "SCHL_ETP_PACKAGE")
  private String schlEtpPackage;

  @Column(name = "SCHL_ETP_MEDIA")
  private String schlEtpMedia;

  @Column(name = "SCHL_FAX")
  private String schlFax;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "NEW_MINCODE")
  private String newMincode;

  @Column(name = "FRENCH_MINCODE")
  private String frenchMincode;

  @Column(name = "APPEND_TRANS")
  private String appendTrans;

  @Column(name = "SIGNATURE_DISTNO")
  private String signatureDistno;

  @Column(name = "CONTED_FLAG")
  private String contedFlag;

  @Column(name = "ETP_EMAIL")
  private String etpEmail;

  @Column(name = "ETP_EMAIL_FLAG")
  private String etpEmailFlag;

  @Column(name = "OFFSHORE_FLAG")
  private String offshoreFlag;

}
