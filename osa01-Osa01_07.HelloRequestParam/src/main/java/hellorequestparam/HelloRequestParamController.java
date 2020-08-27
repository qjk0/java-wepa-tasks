package hellorequestparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloRequestParamController {

    @GetMapping("/hello")
    @ResponseBody
    public String greet(@RequestParam String name) {
        return "Hello " + (name.equals("") ? " John Doe" : name);
        
    }
}
