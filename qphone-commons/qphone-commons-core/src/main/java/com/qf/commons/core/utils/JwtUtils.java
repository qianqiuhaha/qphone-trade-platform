package com.qf.commons.core.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
public class JwtUtils {
    //密钥由调用方来决定
    private static String secretKey = "84950c0b-336a-4867-9954-0b2e69ad1a5a";
    //有效期也由调用方来决定
    private static long ttl = 2 * 60 * 60 * 1000;
//    private static long ttl = 30 * 1000;

    /**
     * 创建jwt令牌
     * @return
     */
    public static String createJwtToken(Long uid){
        long now = System.currentTimeMillis();
        JwtBuilder jwtBuilder = Jwts.builder()
                .claim("uid", uid)
                .setIssuedAt(new Date(now))
                .signWith(SignatureAlgorithm.HS256, secretKey);
        if(ttl > 0){
            jwtBuilder.setExpiration(new Date(now + ttl));
        }
        return jwtBuilder.compact();
    }

    //解析jwt的令牌
    public static Long parseJwtToken(String jwtToken){
        try {
            return Long.valueOf((int) Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(jwtToken).getBody().get("uid"));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String jwtToken = JwtUtils.createJwtToken(200L);
        System.out.println(jwtToken);

//        Long uid = JwtUtils.parseJwtToken("eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjIwMCwiaWF0IjoxNjU2OTE1MTExLCJleHAiOjE2NTY5MTUxNDF9.26Bn7cstu31WUiQ82ZfA6G4A1K_fxuk8QLBk-RKygrA");
//        System.out.println("uid:" + uid);
    }
}
