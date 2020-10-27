package com.mizhi.yxd.tools;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @program: subsidize
 * @description:
 * @author: yangxudong
 * @create: 2020-10-04 15:14
 **/
public class BeanUtils {
    public static  <T> List<T> copyProperties(List<?> oldList, Class<T> clazz) {
        String old = JSON.toJSONString(oldList);
        return JSON.parseArray(old, clazz);
    }
}
