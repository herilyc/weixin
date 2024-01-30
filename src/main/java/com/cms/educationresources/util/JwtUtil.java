package com.cms.educationresources.util;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.gson.io.GsonSerializer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Data
@Component
@ConfigurationProperties("jwt.data")
public class JwtUtil {
    //密钥
    private static final String SECRET = "yZ1sS5yR5fG5eL6xD6vO9hO1oO1yF7bK9fH0bL6jF8jX0qO2qY9bR0mG2qT2iL5eZ7iK8vH3";
    //Authorization
    private String header;

    private static SecretKey generateKey(String secret) {
        byte[] encodedKey = Base64.decodeBase64(secret);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA256");
    }

    //创建token
    //传入userid
    public String createToken(String userId){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,24*60*60*7);
        String compact = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(calendar.getTime())
                .signWith(generateKey(SECRET),SignatureAlgorithm.HS256)
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .compact();

        return compact;
    }

    //校验jwt
    public Claims parseToken(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(generateKey(SECRET))
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.error("jwt match error:{}",e);
            return null;
        }
    }

    //判断token是否过期
    public boolean judgeTokenExpiration(Date expiration){
        return expiration.before(new Date());
    }
}