package com.powernode.jwt;

import com.powernode.jwt.util.JWTUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-28 09:17
 */
public class Test {

    public static void main(String[] args) {
//        List<String> auth = new ArrayList<>();
//        auth.add("user:add");
//        auth.add("user:query");
//        auth.add("user:delete");
//        String jwt = JWTUtils.getJWT("zhangsan", "1001", auth);
        String jwt = "eyJ0eXAiOiJKV1QiLCJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJ1SWQiOiIxMDAxIiwidW5hbWUiOiJ6aGFuZ3NhbiIsImF1dGgiOlsidXNlcjphZGQiLCJ1c2VyOnF1ZXJ5IiwidXNlcjpkZWxldGUiXSwiZXhwIjoxNjY0MzMzMDkwLCJpYXQiOjE2NjQzMzIxOTB9.YnhxHwQ8hg_zk_1NGReabaDtml_pfCWzFdctuleoId8";
        //System.out.println("jwt=" + jwt);
        boolean verifyToken = JWTUtils.verifyToken(jwt);
        if (verifyToken) {
            String userId = JWTUtils.getUserId(jwt);
            System.out.println("userId=" + userId);
            String userName = JWTUtils.getUserName(jwt);
            System.out.println("userName=" + userName);
            List<String> auth = JWTUtils.getAuth(jwt);
            for (String s : auth) {
                System.out.println(s);
            }
        } else {
            System.out.println("登录信息已经过期");
        }


    }
}
