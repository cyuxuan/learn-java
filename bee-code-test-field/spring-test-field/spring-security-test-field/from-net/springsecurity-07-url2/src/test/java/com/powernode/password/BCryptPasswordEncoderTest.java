package com.powernode.password;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BCryptPasswordEncoderTest {

    @Test
    void testBcrypt(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        //编码
        String encode1 = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");
        String encode3 = passwordEncoder.encode("123456");
        log.info(encode1);
        log.info(encode2);
        log.info(encode3);
        //对比方法，参数1：明文 参数2：密文
        boolean result1 = passwordEncoder.matches("123456", encode1);
        boolean result2 = passwordEncoder.matches("123456", encode2);
        boolean result3 = passwordEncoder.matches("123456", encode3);
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);


    }
}
