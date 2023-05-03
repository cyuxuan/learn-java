package club.beenest.blog.support.common.service.log.impl;

import club.beenest.blog.support.common.dao.log.ExceptionLogMapper;
import club.beenest.blog.support.common.entity.log.ExceptionLog;
import club.beenest.blog.support.common.entity.useragent.UserAgent;
import club.beenest.blog.support.common.service.log.ExceptionLogService;
import club.beenest.blog.support.exception.PersistenceException;
import club.beenest.blog.support.util.IpAddressUtils;
import club.beenest.blog.support.util.UserAgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * 异常日志业务层实现
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {
    @Autowired
    ExceptionLogMapper exceptionLogMapper;
    @Autowired
    UserAgentUtils userAgentUtils;

    @Override
    public List<ExceptionLog> getExceptionLogListByDate(String startDate, String endDate) {
        return exceptionLogMapper.getExceptionLogListByDate(startDate, endDate);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveExceptionLog(ExceptionLog log) {
        String ipSource = IpAddressUtils.getCityInfo(log.getIp());
        UserAgent userAgentDTO = userAgentUtils.parseOsAndBrowser(log.getUserAgent());
        log.setIpSource(ipSource);
        log.setOs(userAgentDTO.getOs());
        log.setBrowser(userAgentDTO.getBrowser());
        if (exceptionLogMapper.saveExceptionLog(log) != 1) {
            throw new PersistenceException("日志添加失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteExceptionLogById(Long id) {
        if (exceptionLogMapper.deleteExceptionLogById(id) != 1) {
            throw new PersistenceException("删除日志失败");
        }
    }
}
