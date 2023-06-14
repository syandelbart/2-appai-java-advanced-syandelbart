package fact.it.renovationproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import fact.it.renovationproject.model.RenovationProject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() { return "index"; }

    @RequestMapping("/paint")
    public String calculatePaint(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));

        boolean paintCeiling = (request.getParameter("paintCeiling") != null);

        int amountLayers = Integer.parseInt(request.getParameter("layerAmount"));

        RenovationProject renovationproject = new RenovationProject(length,width,height);
        renovationproject.setCeilingIncluded(paintCeiling);
        renovationproject.setNumberOfLayers(amountLayers);

        model.addAttribute("name",name);
        model.addAttribute("project",renovationproject);


        return "paint";
    }
}
