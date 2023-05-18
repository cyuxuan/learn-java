package com.powernode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/query")
    @PreAuthorize("hasAuthority('student:query')")
    public String queryInfo(){
        //  /templates/student/query.html
        return "student/query";
    }
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('student:add')")
    public String addInfo(){
        return "student/add";
    }
    @GetMapping("/update")
    @PreAuthorize("hasAuthority('student:update')")
    public String updateInfo(){
        return "student/update";
    }
    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('student:delete')")
    public String deleteInfo(){
        return "student/delete";
    }
    @GetMapping("/export")
    @PreAuthorize("hasAuthority('student:export')")
    public String exportInfo(){
        return "student/export";
    }
}