package club.beenest.blog.service.visit.impl;

import club.beenest.blog.dao.visit.CityVisitorMapper;
import club.beenest.blog.entity.visit.CityVisitor;
import club.beenest.blog.service.visit.CityVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 城市访客数量统计业务层实现
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Service
public class CityVisitorServiceImpl implements CityVisitorService {
    @Autowired
    CityVisitorMapper cityVisitorMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveCityVisitor(CityVisitor cityVisitor) {
        cityVisitorMapper.saveCityVisitor(cityVisitor);
    }
}
