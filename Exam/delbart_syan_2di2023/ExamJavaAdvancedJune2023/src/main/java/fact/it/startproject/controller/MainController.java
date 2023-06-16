package fact.it.startproject.controller;

import fact.it.startproject.model.Company;
import fact.it.startproject.model.Department;
import fact.it.startproject.repository.CompanyRepository;
import fact.it.startproject.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    CompanyRepository companyRepository;
    DepartmentRepository departmentRepository;

    MainController(CompanyRepository companyRepository,DepartmentRepository departmentRepository) {
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping("/1_listcompanies.html")
    public String listCompanies(Model model) {

        List<Company> companies = this.companyRepository.findAllSortedByLocation();
        model.addAttribute("companies",companies);

        return "1_listcompanies";

    }

    @RequestMapping("2_listdepartments.html")
    public String listDepartments(Model model) {

        List<Department> departments = this.departmentRepository.findAll();

        model.addAttribute("departments",departments);

        return "2_listdepartments";

    }
}
