package com.windeaker.jwtdemo;

import com.windeaker.jwtdemo.model.DO.User;
import com.windeaker.jwtdemo.model.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class JWTStandaloneTest {

    @Test
    public void testGeneJwt(){
        User user=new User();
        user.setId(100L);
        user.setHeadImg("nothing");
        user.setName("windeaker");
        String token= JwtUtil.geneJsonWebToken(user);
        System.out.println(token);

    }

    @Test
    public void testCheck(){
        String jwtToken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3aW5kZWFrZXIiLCJpZCI6MTAwLCJuYW1lIjoid2luZGVha2VyIiwiaW1nIjoibm90aGluZyIsImlhdCI6MTU2OTQwNjkxMywiZXhwIjoxNTcwMDExNzEzfQ.Ze5TQvdZRWq-91gN_5eJE6D5RjBg48NppLiMveOSqMR4DWWntub4CKJm0FPx1hqw70EXQ5mORPfcdfxglUn8sw";
        Claims claims = JwtUtil.checkJWT(jwtToken);
        if(claims != null){
            String name = (String)claims.get("name");
            String img = (String)claims.get("img");
            int id =(Integer) claims.get("id");
            System.out.println(name);
            System.out.println(img);
            System.out.println(id);
        }else{
            System.out.println("非法token");
        }
    }
}
