package cn.cyuxuan.dao.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestDao {
    String selectNameById(int id);

    String selectSexById(int id);
}
