package ca.bc.gov.educ.api.pen.trax.exception;

/**
 * The type Trax api runtime exception.
 */
public class TraxAPIRuntimeException extends RuntimeException {

  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 5241655513745148898L;

  /**
   * Instantiates a new Trax api runtime exception.
   *
   * @param message the message
   */
  public TraxAPIRuntimeException(String message) {
		super(message);
	}

}
