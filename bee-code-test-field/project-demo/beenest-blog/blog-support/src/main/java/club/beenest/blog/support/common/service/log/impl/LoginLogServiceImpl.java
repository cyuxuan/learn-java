/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.service.log.impl;

import club.beenest.blog.support.common.dao.log.LoginLogMapper;
import club.beenest.blog.support.common.entity.log.LoginLog;
import club.beenest.blog.support.common.entity.useragent.UserAgent;
import club.beenest.blog.support.common.service.log.LoginLogService;
import club.beenest.blog.support.exception.PersistenceException;
import club.beenest.blog.support.util.IpAddressUtils;
import club.beenest.blog.support.util.UserAgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 日志信息记录
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    LoginLogMapper loginLogMapper;
    @Autowired
    UserAgentUtils userAgentUtils;

    @Override
    public List<LoginLog> getLoginLogListByDate(String startDate, String endDate) {
        return loginLogMapper.getLoginLogListByDate(startDate, endDate);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveLoginLog(LoginLog log) {
        String ipSource = IpAddressUtils.getCityInfo(log.getIp());
        UserAgent userAgentDTO = userAgentUtils.parseOsAndBrowser(log.getUserAgent());
        log.setIpSource(ipSource);
        log.setOs(userAgentDTO.getOs());
        log.setBrowser(userAgentDTO.getBrowser());
        if (loginLogMapper.saveLoginLog(log) != 1) {
            throw new PersistenceException("日志添加失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteLoginLogById(Long id) {
        if (loginLogMapper.deleteLoginLogById(id) != 1) {
            throw new PersistenceException("删除日志失败");
        }
    }
}
