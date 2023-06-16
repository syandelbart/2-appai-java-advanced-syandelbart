package fact.it.primecalculator.controllers;

import jakarta.servlet.http.HttpServletRequest;
import fact.it.primecalculator.models.PrimeCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/primes")
    public String calculatePrimes(HttpServletRequest request, Model model) {

        int number = Integer.parseInt(request.getParameter("number"));

        PrimeCalculator primeCalculator = new PrimeCalculator();

        List<Integer> primes = primeCalculator.getAllPrimesUntil(number);

        model.addAttribute("primes",primes);

        return "primes";
    }

}
