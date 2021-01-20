package com.cjw.util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class StringUtil {

    public static BloomFilter bloomFilter = null;

    static {
        bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),1000000 ,0.001 );
        bloomFilter.put("zhangsan_111");
        bloomFilter.put("zhangsan_111111");

    }

    public static final String LOGIN_OK="登录成功";
    public static final Long CACHE_TIME=60l;
    public static final Long CACHE_NULL=2l;
    public static final Long WAIT_TIME=5l;
    public static final Long GET_TIME=3l;

    public static final  String UPDATE_OK="修改成功";
    public static final  String UPDATE_ERROR="修改失败";
    public static final  String BUY_OK="购买成功,等待出票";
    public static final  String BUY_NO="购买失败";

    public static boolean isNull(String str){
        boolean flag = true;
        if (str!=null&&!"".equals(str)){
            flag = false;
        }
        return flag;
    }
}
