package com.powernode.util;

import java.util.Arrays;
import java.util.List;

public class JwtTest {
    public static void main(String[] args) {
        JwtTest jwtTest=new JwtTest();
        String token = jwtTest.createToken();
        JwtUtils jwtUtils =new JwtUtils();
        boolean verifyResult = jwtUtils.verifyToken(token);
        if(verifyResult){
            //从token获取权限
            List<String> authList = jwtUtils.getUserAuthFromToken(token);
            System.out.println(authList);
        }
//        jwtTest.verifyToken();
    }
    public String createToken(){
        JwtUtils jwtUtils=new JwtUtils();
        List<String> authList= Arrays.asList("student:query","student:add","student:update");
        String myCreateJwt = jwtUtils.createJwt(19, "obama", authList);
        System.out.println(myCreateJwt);
        return myCreateJwt;
    }

    public void verifyToken(){
        String jwt="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyQXV0aCI6WyJzdHVkZW50OnF1ZXJ5Iiwic3R1ZGVudDphZGQiLCJzdHVkZW50OnVwZGF0ZSJdLCJpc3MiOiJ0aG9tYXMiLCJleHAiOjE2NzU3MzMwNzcsInVzZXJOYW1lIjoib2JhbWEiLCJpYXQiOjE2NzU3MzMwNDcsInVzZXJJZCI6MTl9.ZdRnI5XLFaw6mc1J7X5beHp0KsiYBZczanYzrnvT8yQ";
        JwtUtils jwtUtils = new JwtUtils();
        boolean verifyResult = jwtUtils.verifyToken(jwt);
        System.out.println(verifyResult);
    }
}
