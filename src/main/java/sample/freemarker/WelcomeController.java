package sample.freemarker;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private String message = "Hello World";

	@RequestMapping("/test")
	public String welcome(Map<String, Object> model) {
		model.put("name", this.message);
		return "test";
	}

}
