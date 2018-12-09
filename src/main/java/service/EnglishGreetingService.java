package service;
import service.GreetingService;
import org.springframework.stereotype.Component;
@Component
public class EnglishGreetingService implements GreetingService {

    @Override
    public String greet() {
        return "Hello World!";
    }
}
