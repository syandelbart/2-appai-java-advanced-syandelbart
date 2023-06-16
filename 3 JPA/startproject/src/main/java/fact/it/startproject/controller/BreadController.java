package fact.it.startproject.controller;

import fact.it.startproject.model.Bread;
import fact.it.startproject.repository.BreadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BreadController {
    private BreadRepository breadRepository;
    private boolean created;

    public BreadController(BreadRepository breadRepository) {

        this.breadRepository = breadRepository;
        this.created = true;
    }

    @PostConstruct
    public void fillDatabaseTemporary() {
        for (int i = 0; i < 10; i++) {
            Bread bread = new Bread();
            bread.setName("Bread" + i);
            bread.setPrice(25.5-i);
            breadRepository.save(bread);
        }

        this.created = true;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breads",list);

        if(created) {
            model.addAttribute("created","Breads were created.");
            created = false;
        }

        return "index";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/search")
    public String search(Model model,HttpServletRequest request) {
        String searchString = request.getParameter("breadName");
        String getCheapest = request.getParameter("cheapest");
        String getSearch = request.getParameter("search");

        if(getSearch != null) {
            List<Bread> queryResult = breadRepository.findAllByNameStartsWith(searchString);
            model.addAttribute("breads",queryResult);
            return "index";
        }

        if(getCheapest != null) {
            List<Bread> queryResult = breadRepository.findCheapest();
            model.addAttribute("breads",queryResult);
            return "index";
        }

        return "index";
    }

    @RequestMapping("/processadd")
    public String processAdd(Model model, HttpServletRequest request) {
        String breadName = request.getParameter("name");
        Double breadPrice = Double.parseDouble(request.getParameter("price"));
        Bread bread = new Bread();
        bread.setName(breadName);
        bread.setPrice(breadPrice);
        breadRepository.save(bread);
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breads",list);
        return "index";
    }



    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
//breadRepository.findById(breadId) returns an Optional, a value that can also be null. By using the .get()-method we can retrieve the actual value.
        Bread bread = breadRepository.findById(breadId).get();
        model.addAttribute("bread", bread);
        return "edit";
    }
    @RequestMapping("/processedit")
    public String processEdit(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        String breadName = request.getParameter("name");
        Double breadPrice = Double.parseDouble(request.getParameter("price"));
        Bread bread = breadRepository.findById(breadId).get();
        bread.setName(breadName);
        bread.setPrice(breadPrice);
        breadRepository.save(bread);
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breads",list);
        return "index";
    }
    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request){
        Long breadId = Long.valueOf(request.getParameter("breadId"));
        breadRepository.deleteById(breadId);
        List<Bread> list = breadRepository.findAll();
        model.addAttribute("breads",list);
        return "index";
    }
}
