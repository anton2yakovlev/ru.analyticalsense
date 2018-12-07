package ru.analyticalsense.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.analyticalsense.domain.Factor;
import ru.analyticalsense.domain.Role;
import ru.analyticalsense.domain.User;
import ru.analyticalsense.repos.FactorRepo;

import java.lang.String;
import javax.management.Query;
import java.util.Collections;
import java.util.Map;


@Controller
public class FactorController  {

    @Autowired
    private FactorRepo factorRepo;

    @GetMapping("/factor")
    public String main(Map<String, Object> model) {
        //Iterable<Factor> factors = factorRepo.findAll();
        //model.put("factors", factors);

        return "factor";
    }

    @PostMapping("/factor")
    public String addFactor(
            @RequestParam String factorName,
            @RequestParam String factorQuery,
            Map<String, Object> model) {

        Factor factor = new Factor(factorName, factorQuery);
        factorRepo.save(factor);

        Iterable<Factor> factors = factorRepo.findAll();
        model.put("factors", factors);

        return "factor";
    }
}
