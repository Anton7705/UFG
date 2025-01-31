package ru.dorogov.web.controllers.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dorogov.web.repo.CompanyRepo;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    CompanyService companyService;

    @GetMapping("/company/add")
    public String userAdd() {
        return "companyAdd";
    }

    @PostMapping("/company/addRoot")
    public String companyChangeRoot(@RequestParam("name") String name, @RequestParam("domain") String domain) {
        return companyService.addCompany(name, domain);
    }

    @GetMapping("/allCompanies")
    public String allCompanies(Model model) {
        return companyService.allCompanies(model);
    }

    @GetMapping("/changeCompany/{id}")
    public String userChange(@PathVariable(value = "id") Long id, Model model) {
        if (!companyRepo.existsById(id)) {
            return "home";
        }
        return companyService.userChange(id, model);
    }

}
