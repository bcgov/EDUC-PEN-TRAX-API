package ca.bc.gov.educ.api.pen.trax.config;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type TRAX api mvc config.
 *
 * @author Om
 */
@Configuration
public class TraxAPIMVCConfig implements WebMvcConfigurer {

  /**
   * The TRAX api interceptor.
   */
  @Getter(AccessLevel.PRIVATE)
  private final RequestResponseInterceptor requestResponseInterceptor;

  /**
   * Instantiates a new TRAX api mvc config.
   *
   * @param requestResponseInterceptor the School api interceptor
   */
  @Autowired
  public TraxAPIMVCConfig(final RequestResponseInterceptor requestResponseInterceptor) {
    this.requestResponseInterceptor = requestResponseInterceptor;
  }

  /**
   * Add interceptors.
   *
   * @param registry the registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(requestResponseInterceptor).addPathPatterns("/**");
  }
}
