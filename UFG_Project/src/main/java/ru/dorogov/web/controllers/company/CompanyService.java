package ru.dorogov.web.controllers.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.dorogov.web.repo.CompanyRepo;
import ru.dorogov.web.tables.Company;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepo companyRepo;

    List<Company> toList(Long id) {
        Optional<Company> user = companyRepo.findById(id);
        ArrayList<Company> list = new ArrayList<>();
        user.ifPresent(list::add);
        return list;
    }

    public String addCompany(String name, String domain) {
        Company company = new Company(name, domain);
        companyRepo.save(company);
        return "redirect:/root";
    }

    public String allCompanies(Model model) {
        model.addAttribute("company", companyRepo.findAll());
        return "companiesInfo";
    }

    public String userChange(Long id, Model model) {
        model.addAttribute("companyInf", toList(id));
        return "companyChange";
    }
}
