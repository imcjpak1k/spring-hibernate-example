package net.codejava.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
		appCtx.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic dispather = servletContext.addServlet("SpringDispather", new DispatcherServlet(appCtx));
		dispather.setLoadOnStartup( 1 );
		dispather.addMapping("/");
	}

}
