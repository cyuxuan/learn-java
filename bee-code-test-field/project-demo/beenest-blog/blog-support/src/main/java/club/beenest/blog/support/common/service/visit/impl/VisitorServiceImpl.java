/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.common.service.visit.impl;

import club.beenest.blog.entity.visit.Visitor;
import club.beenest.blog.support.common.dao.visit.VisitorMapper;
import club.beenest.blog.support.common.service.visit.VisitorService;
import club.beenest.blog.support.common.entity.log.VisitLogUuidTime;
import club.beenest.blog.support.common.entity.useragent.UserAgent;
import club.beenest.blog.support.common.service.redis.RedisService;
import club.beenest.blog.support.common.service.redis.impl.RedisKeyConstants;
import club.beenest.blog.support.exception.PersistenceException;
import club.beenest.blog.support.util.IpAddressUtils;
import club.beenest.blog.support.util.UserAgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 访客统计业务层实现
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    VisitorMapper visitorMapper;

    @Autowired
	RedisService redisService;

    @Autowired
	UserAgentUtils userAgentUtils;

    @Override
    public List<Visitor> getVisitorListByDate(String startDate, String endDate) {
        return visitorMapper.getVisitorListByDate(startDate, endDate);
    }

    @Override
    public List<String> getNewVisitorIpSourceByYesterday() {
        return visitorMapper.getNewVisitorIpSourceByYesterday();
    }

    @Override
    public boolean hasUUID(String uuid) {
        return visitorMapper.hasUUID(uuid) != 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveVisitor(Visitor visitor) {
        String ipSource = IpAddressUtils.getCityInfo(visitor.getIp());
        UserAgent userAgentDTO = userAgentUtils.parseOsAndBrowser(visitor.getUserAgent());
        visitor.setIpSource(ipSource);
        visitor.setOs(userAgentDTO.getOs());
        visitor.setBrowser(userAgentDTO.getBrowser());
        if (visitorMapper.saveVisitor(visitor) != 1) {
            throw new PersistenceException("访客添加失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatePVAndLastTimeByUUID(VisitLogUuidTime dto) {
        visitorMapper.updatePVAndLastTimeByUUID(dto);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteVisitor(Long id, String uuid) {
        // 删除Redis中该访客的uuid
        redisService.deleteValueBySet(RedisKeyConstants.IDENTIFICATION_SET, uuid);
        if (visitorMapper.deleteVisitorById(id) != 1) {
            throw new PersistenceException("删除访客失败");
        }
    }
}
