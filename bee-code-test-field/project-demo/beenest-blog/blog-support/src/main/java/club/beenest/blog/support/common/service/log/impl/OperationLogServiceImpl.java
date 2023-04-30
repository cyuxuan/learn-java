package club.beenest.blog.support.common.service.log.impl;

import club.beenest.blog.support.common.dao.log.OperationLogMapper;
import club.beenest.blog.support.common.entity.log.OperationLog;
import club.beenest.blog.support.common.entity.useragent.UserAgent;
import club.beenest.blog.support.common.service.log.OperationLogService;
import club.beenest.blog.support.exception.PersistenceException;
import club.beenest.blog.support.util.IpAddressUtils;
import club.beenest.blog.support.util.UserAgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * 操作日志业务层实现
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    OperationLogMapper operationLogMapper;

    @Autowired
	UserAgentUtils userAgentUtils;

    @Override
    public List<OperationLog> getOperationLogListByDate(String startDate, String endDate) {
        return operationLogMapper.getOperationLogListByDate(startDate, endDate);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOperationLog(OperationLog log) {
        String ipSource = IpAddressUtils.getCityInfo(log.getIp());
        UserAgent userAgentDTO = userAgentUtils.parseOsAndBrowser(log.getUserAgent());
        log.setIpSource(ipSource);
        log.setOs(userAgentDTO.getOs());
        log.setBrowser(userAgentDTO.getBrowser());
        if (operationLogMapper.saveOperationLog(log) != 1) {
            throw new PersistenceException("日志添加失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteOperationLogById(Long id) {
        if (operationLogMapper.deleteOperationLogById(id) != 1) {
            throw new PersistenceException("删除日志失败");
        }
    }
}
