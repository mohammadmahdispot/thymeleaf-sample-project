package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("EMPLOYEE")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServiceImpl;



    @GetMapping("/getAll")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", employeeServiceImpl.getAllEmployee());
        return "index";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeServiceImpl.create(employee);
        return "redirect:/EMPLOYEE/getAll";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeServiceImpl.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteById(@PathVariable(value = "id") Long id) {
        employeeServiceImpl.deleteById(id);
        return "redirect:/EMPLOYEE/getAll";
    }

}

