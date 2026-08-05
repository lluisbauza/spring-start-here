package com.lluisbauza.activity_05_dynamic_employee_profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/employee")
    public String viewEmployee(
            @RequestParam String name,
            @RequestParam(required = false) String department,
            @RequestParam(defaultValue = "1") int accessLevel,
            Model page
    ) {
        page.addAttribute("name", name);
        page.addAttribute("department", department);

        if (accessLevel == 1) {
            page.addAttribute("accessDescription", "Basic Access");
        } else if (accessLevel == 2) {
            page.addAttribute("accessDescription", "Standard Access");
        }  else if (accessLevel == 3) {
            page.addAttribute("accessDescription", "Full Access");
        } else {
            page.addAttribute("accessDescription", "Invalid Access Level");
        }

        return "employee.html";
    }

}
