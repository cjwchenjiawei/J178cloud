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

    public static boolean isNull(String str){
        boolean flag = true;
        if (str!=null&&!"".equals(str)){
            flag = false;
        }
        return flag;
    }
}
