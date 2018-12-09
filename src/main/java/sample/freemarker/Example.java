package sample.freemarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EnglishGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
@Configuration
@ComponentScan({"service","sample.freemarker"})
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "sample.freemarker")
//@EnableConfigurationProperties(DataSourceProperties.class)
//@EnableJpaRepositories
//@SpringBootApplication
public class Example extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<Example> applicationClass = Example.class;
}


@RestController
class GreetingController {
    @Autowired
    EnglishGreetingService greetingService;
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        //return "Hello, " + name + "!";
 	return greetingService.greet();
    }

	  @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
} 


