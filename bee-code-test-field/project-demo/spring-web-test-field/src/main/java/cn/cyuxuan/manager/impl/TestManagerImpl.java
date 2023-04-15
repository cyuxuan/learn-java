package cn.cyuxuan.manager.impl;

import cn.cyuxuan.manager.TestManeger;
import org.springframework.stereotype.Service;

@Service
public class TestManagerImpl implements TestManeger {

    @Override
    public String getStr() {
        return "test Manager";
    }
}
