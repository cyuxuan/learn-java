package cn.cyuxuan.service.test2.impl;

import cn.cyuxuan.manager.TestManeger;
import cn.cyuxuan.service.test2.Testa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestImpl implements Testa {

    @Autowired
    TestManeger testManager;

    @Override
    public String tt() {
        return "321";
    }
}
