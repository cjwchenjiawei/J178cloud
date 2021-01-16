package com.cjw.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cjw.dto.UserDto;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    private  static final  long EXPIRE_TIME=1000*60*5;
    private static  final  String TOKEN_SECRET="J178";
    public static String createToken(UserDto userDto) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        String token= JWT.create().withHeader(header)
                .withClaim("username",userDto.getUsername())
                .withClaim("power",userDto.getPower())
                .withExpiresAt(date).sign(algorithm);
        return token;
    }

    /**
     *认证
     * @param token
     * @return
     */
   public static UserDto verifierJwt(String token){
       //私钥及加密算法
       Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
       UserDto userDto=null;
       JWTVerifier verifier = JWT.require(algorithm).build();
       try {
           DecodedJWT jwt = verifier.verify(token);
           userDto=new UserDto();
           //从token中取出内容
            userDto.setPower(jwt.getClaim("power").asInt());
            userDto.setUsername(jwt.getClaim("username").asString());
       }catch (Exception e){
           return  userDto;
       }
       return userDto;
   }
}
