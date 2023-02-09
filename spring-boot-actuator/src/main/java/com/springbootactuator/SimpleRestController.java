package com.springbootactuator;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
	
	 @GetMapping("/example")
     public String example() {
         return "Hello User !! " + new Date();
     }
}

/* open: 
 * http://localhost:8080/actuator
 * http://localhost:8080/example
 * http://localhost:8080/actuator/threaddump
 * http://localhost:8080/actuator/health
 * 
 * Endpoint	   Usage
/auditevents	Returns all auto-configuration candidates and the reason why they ‘were’ or ‘were not’ applied.
/beans	Returns a complete list of all the Spring beans in your application.
/mappings	Displays a collated list of all @RequestMapping paths..
/env	Returns list of properties in current environment
/health	Returns application health information.
/caches	It exposes available caches.
/conditions	Shows the conditions that were evaluated on configuration and auto-configuration.
/configprops	It displays a collated list of all @ConfigurationProperties.
/integrationgraph	It shows the Spring Integration graph. Requires a dependency on spring-integration-core.
/loggers	The configuration of loggers in the application..
/scheduledtasks	Displays the scheduled tasks in the application.
/sessions	Returns trace logs (by default the last 100 HTTP requests). Requires an HttpTraceRepository bean.
/httptrace	It allows retrieval and deletion of user sessions from a Spring Session-backed session store. Requires a Servlet-based web application using Spring Session.
/shutdown	Lets the application be gracefully shutdown. Disabled by default.
/threaddump	It performs a thread dump.
/metrics	It shows several useful metrics information like JVM memory used, system CPU usage, open files, and much more.
 */
