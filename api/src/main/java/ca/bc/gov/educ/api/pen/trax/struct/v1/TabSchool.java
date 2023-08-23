package ca.bc.gov.educ.api.pen.trax.struct.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 * The type Tab school.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TabSchool implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 1L;

  @Size(max = 8)
  @NotNull(message = "mincode can not be null.")
  private String mincode;

  @Size(max = 40)
  private String schlName;

  @Size(max = 40)
  private String address1;

  @Size(max = 40)
  private String address2;

  @Size(max = 30)
  private String city;

  @Size(max = 2)
  private String provCode;

  @Size(max = 2)
  private String cntryCode;

  @Size(max = 7)
  private String postal;

  @Size(max = 40)
  private String princName;

  @Size(max = 1)
  private String openFlag;

  @Size(max = 1)
  private String schlEtpSys;

  @Size(max = 1)
  private String schlIndType;

  @Size(max = 3)
  private String schlIndAffil;

  @Size(max = 1)
  private String schlOrg;

  @Size(max = 10)
  private String phone;

  @Size(max = 1)
  private String ministryContact;

  @Size(max = 7)
  private String filler7;

  @Size(max = 1)
  private String xcriptElig;

  @Size(max = 1)
  private String dogwoodElig;

  @Size(max = 1)
  private String mailerType;

  @Size(max = 1)
  private String loomisFlag;

  @Size(max = 1)
  private String schlEtpPackage;

  @Size(max = 1)
  private String schlEtpMedia;

  @Size(max = 10)
  private String schlFax;

  @Size(max = 40)
  private String email;

  @Size(max = 8)
  private String newMincode;

  @Size(max = 8)
  private String frenchMincode;

  @Size(max = 1)
  private String appendTrans;

  @Size(max = 3)
  private String signatureDistno;

  @Size(max = 1)
  private String contedFlag;

  @Size(max = 100)
  private String etpEmail;

  @Size(max = 1)
  private String etpEmailFlag;

  @Size(max = 1)
  private String offshoreFlag;

}
