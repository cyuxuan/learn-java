package club.beenest.blog.service.visit.impl;

import club.beenest.blog.dao.visit.VisitRecordMapper;
import club.beenest.blog.entity.visit.VisitRecord;
import club.beenest.blog.service.visit.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 访问记录业务层实现
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Service
public class VisitRecordServiceImpl implements VisitRecordService {
    @Autowired
    VisitRecordMapper visitRecordMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveVisitRecord(VisitRecord visitRecord) {
        visitRecordMapper.saveVisitRecord(visitRecord);
    }
}
