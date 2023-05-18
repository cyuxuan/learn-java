package com.powernode.service.impl;

import com.powernode.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    @Override
    @PreAuthorize("hasAuthority('teacher:add')") //预授权
    public String add() {
        log.info("添加教师成功");
        return "添加教师成功";
    }

    @Override
    @PreAuthorize("hasAnyAuthority('teacher:update')") //预授权
    public String update() {
        log.info("修改教师成功");
        return "修改教师成功";
    }

    @Override
    @PreAuthorize("hasAuthority('teacher:delete')") //预授权
    public String delete() {
        log.info("删除教师成功");
        return "删除教师成功";
    }

    @Override
    @PreAuthorize("hasAnyAuthority('teacher:query')") //预授权
    public String query() {
        log.info("查询教师成功");
        return "查询教师成功";
    }
}