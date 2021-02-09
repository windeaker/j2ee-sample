package com.windeaker.jwtdemo.model.utils;

import com.windeaker.jwtdemo.model.DO.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static final String SUBJECT="windeaker";
    public static final String SECRETKEY="windeaker@0917";
    //过期事件，毫秒，一周
    public static final long EXPIRE=1000*60*60*24*7;

    public static String geneJsonWebToken(User user){
        if (user == null ||
                user.getId() == null ||
                user.getName() == null ||
                user.getHeadImg() == null) {

            return null;
        }
        String token= Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getName())
                .claim("img",user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS512,SECRETKEY).compact();
        return token;
  }

  public static Claims checkJWT(String jwtToken){
        try{
            final Claims claims=Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(jwtToken).getBody();
            return claims;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
  }
}
