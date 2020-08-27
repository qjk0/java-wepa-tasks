package calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @GetMapping("/add")
    @ResponseBody
    public String addNumbers(@RequestParam Integer numOne, @RequestParam Integer numTwo) {
        return String.valueOf(numOne + numTwo);
    }

    @GetMapping("/multiply")
    @ResponseBody
    public String multiplyNumbers(@RequestParam Integer numOne, @RequestParam Integer numTwo) {
        return String.valueOf(numOne * numTwo);
    }

}
