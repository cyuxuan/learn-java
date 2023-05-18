package cn.cyuxuan.manager.impl;

import cn.cyuxuan.manager.TestManeger;
import org.springframework.stereotype.Service;

@Service
public class TestManagerImpl implements TestManeger {

    @Override
    public String getStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6000; i++) {
            sb.append(i);
        }
        return "test Manager" + sb.toString();
    }
}
