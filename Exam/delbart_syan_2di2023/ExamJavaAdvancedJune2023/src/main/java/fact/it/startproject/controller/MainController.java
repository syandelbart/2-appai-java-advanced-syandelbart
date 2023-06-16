package fact.it.startproject.controller;

import fact.it.startproject.model.Company;
import fact.it.startproject.model.Department;
import fact.it.startproject.repository.CompanyRepository;
import fact.it.startproject.repository.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("3_editdepartment.html")
    public String editDepartment(Model model, HttpServletRequest request) {
        Long departmentId = Long.parseLong(request.getParameter("departmentId"));

        Department department = this.departmentRepository.getById(departmentId);

        List<Company> companies = this.companyRepository.findAll();

        model.addAttribute("department",department);
        model.addAttribute("companies",companies);

        return "3_editdepartment";


    }

    @RequestMapping("submitEditDepartment")
    public String submitEditDepartment(Model model,HttpServletRequest request) {
        Long departmentId = Long.parseLong(request.getParameter("departmentId"));
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        Long companyId = Long.parseLong(request.getParameter("companyId"));

        Department department = this.departmentRepository.getById(departmentId);

        Company company = this.companyRepository.getById(companyId);

        department.setCompany(company);
        department.setName(name);
        department.setCode(code);

        this.departmentRepository.save(department);

        return "2_listdepartment";


    }
}
