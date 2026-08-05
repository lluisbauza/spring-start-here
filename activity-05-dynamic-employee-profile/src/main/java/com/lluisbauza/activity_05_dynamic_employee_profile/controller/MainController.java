package com.lluisbauza.activity_05_dynamic_employee_profile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/employee")
    public String employee(
            @RequestParam String name,
            @RequestParam(required = false) String department,
            @RequestParam(defaultValue = "1") int accessLevel,
            Model page
    ) {
        page.addAttribute("name", name);
        if (department != null) {
            page.addAttribute("department", department);
        }

        if (accessLevel == 1) {
            page.addAttribute("accessLevel", "Basic Access");
        } else if (accessLevel == 2) {
            page.addAttribute("accessLevel", "Standard Access");
        }  else if (accessLevel == 3) {
            page.addAttribute("accessLevel", "Full Access");
        }

        return "employee.html";
    }

}
