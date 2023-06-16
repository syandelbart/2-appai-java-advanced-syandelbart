package fact.it.ex1.controller;

import fact.it.ex1.model.Payment;
import fact.it.ex1.repository.PaymentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PaymentRestController {
    private PaymentRepository paymentRepository;

    public PaymentRestController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/result")
    public String result(Model model) {
        List<Payment> list = paymentRepository.giveListOfAllPayments();
        model.addAttribute("paymentList", list);
        return "result";
    }
    @GetMapping("/resultasc")
    public String resultAsc(Model model) {
        List<Payment> list = paymentRepository.giveListOfAllPaymentsAsc();
        model.addAttribute("paymentList", list);
        return "result";
    }
    @GetMapping("/resultcash")
    public String resultCash(Model model) {
        List<Payment> list = paymentRepository.giveListOfAllPaymentsCash();
        model.addAttribute("paymentList", list);
        return "result";
    }
    @GetMapping("/resultelec")
    public String resultElec(Model model) {
        List<Payment> list = paymentRepository.giveListOfAllPaymentsElecSortedByCurrency();
        model.addAttribute("paymentList", list);
        return "result";
    }

    @RequestMapping("/resultamount")
    public String resultSearch(Model model, HttpServletRequest request) {
            Double amount = Double.parseDouble(request.getParameter("amount"));
            List<Payment> list = paymentRepository.findAllByAmountGreaterThan(amount);
            model.addAttribute("paymentList", list);
        return "result";
    }
}
