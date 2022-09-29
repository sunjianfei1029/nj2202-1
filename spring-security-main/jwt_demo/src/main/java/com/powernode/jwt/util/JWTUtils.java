package com.powernode.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 用户生成和解析JWT
 * @version 1.0
 * @date:2022-09-28 09:18
 */
public class JWTUtils {

    private static String SECRET = "nj2022";

    /**
     * 生成jwt
     * @param username
     * @param userId
     * @param auth
     * @return
     */
    public static String getJWT(String username, String userId, List<String> auth) {
        // jwt的过期时间
        Date expireDate = new Date(new Date().getTime() + (1000 * 60 * 15));
        // jwt的header
        Map<String, Object> header = new HashMap<String, Object>();
        header.put("alg","HS256");
        header.put("type","jwt");
        return JWT.create()
                .withHeader(header)  // 设置jwt的header
                .withClaim("uname",username)  // 自定义的数据
                .withClaim("uId",userId)    // 自定义的数据
                .withClaim("auth",auth)     // 自定义的数据
                .withExpiresAt(expireDate)      // 超时时间
                .withIssuedAt(new Date())       // 生成jwt的时间
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static boolean verifyToken(String token) {
        // 根据密钥创建jwt的解析对象
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            return true;
        }catch (Exception e) {
            System.out.println("jwt无效");
            e.printStackTrace();
        }

//
        return false;
    }

    /**
     * 从jwt中获取uid
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        // 根据密钥创建jwt的解析对象
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            String uId = decodedJWT.getClaim("uId").asString();
            return uId;
        }catch (Exception e) {
            System.out.println("jwt无效");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 从jwt中获取username
     * @param token
     * @return
     */
    public static String getUserName(String token) {
        // 根据密钥创建jwt的解析对象
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            String uId = decodedJWT.getClaim("uname").asString();
            return uId;
        }catch (Exception e) {
            System.out.println("jwt无效");
            e.printStackTrace();
        }

        return null;
    }

    public static List<String> getAuth(String token) {
        // 根据密钥创建jwt的解析对象
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            List<String> auth = decodedJWT.getClaim("auth").asList(String.class);
            return auth;
        }catch (Exception e) {
            System.out.println("jwt无效");
            e.printStackTrace();
        }

        return null;
    }
}
