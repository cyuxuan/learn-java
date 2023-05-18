package com.powernode.controller;

import com.powernode.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    @GetMapping("/query")
    public String queryInfo() {
        return teacherService.query();
    }

    @GetMapping("/add")
    public String addInfo() {
        return teacherService.add();
    }

    @GetMapping("/update")
    public String updateInfo() {
        int a=10;
        log.info("进入更新教师controller");
        return teacherService.update();
    }

    @GetMapping("/delete")
    public String deleteInfo() {
        return teacherService.delete();
    }
}