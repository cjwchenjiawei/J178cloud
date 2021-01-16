package com.cjw.jedis.util;

import redis.clients.jedis.Jedis;

public class JedisDb {

    public static Jedis createJedis(){
        Jedis jedis=null;
        jedis=new Jedis("127.0.0.1",8000);
        //如有密码需要设置
        //jedis.auth("123456");
        return  jedis;
    }

}
