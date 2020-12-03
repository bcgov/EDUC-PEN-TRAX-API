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
  private final TraxAPIInterceptor traxAPIInterceptor;

  /**
   * Instantiates a new TRAX api mvc config.
   *
   * @param traxAPIInterceptor the School api interceptor
   */
  @Autowired
  public TraxAPIMVCConfig(final TraxAPIInterceptor traxAPIInterceptor) {
    this.traxAPIInterceptor = traxAPIInterceptor;
  }

  /**
   * Add interceptors.
   *
   * @param registry the registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(traxAPIInterceptor).addPathPatterns("/**");
  }
}
