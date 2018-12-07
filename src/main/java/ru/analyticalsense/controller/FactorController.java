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
import ru.analyticalsense.rest.RestAPI;

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
        Iterable<Factor> factors = factorRepo.findAll();
        model.put("factors", factors);

        return "factor";
    }

    @PostMapping("/factor.addFactor")
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

    @PostMapping("/factor.editFactor")
    public String editFactor(
            @RequestParam String newFactorName,
            @RequestParam String newFactorQuery,
            @RequestParam Long id,
            Map<String, Object> model) {

        System.out.println(newFactorName);
        System.out.println(newFactorQuery);
        if (newFactorName != "" && newFactorName != null) {
            factorRepo.findById(id).get().setFactorName(newFactorName);
        }
        if (newFactorQuery != "" && newFactorQuery != null) {
            factorRepo.findById(id).get().setFactorQuery(newFactorQuery);
        }


        Iterable<Factor> factors = factorRepo.findAll();
        model.put("factors", factors);

        return "factor";
    }

    @PostMapping("/factor.delFactor")
    public String delFactor(
            @RequestParam Long id,
            Map<String, Object> model) {
        factorRepo.deleteById(id);
        Iterable<Factor> factors = factorRepo.findAll();
        model.put("factors", factors);

        return "factor";
    }

    @PostMapping("/factor.testFactor")
    public String testFactor(
            @RequestParam Long id,
            Map<String, Object> model) {
        //System.out.println(RestAPI.getXML("test.xml", factorRepo.findById(id).get().getFactorQuery().toString()));

        System.out.println(RestAPI.getXML("qwery.xml"));
        Iterable<Factor> factors = factorRepo.findAll();
        model.put("factors", factors);

        return "factor";
    }
}
