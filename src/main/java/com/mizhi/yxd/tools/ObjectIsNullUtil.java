package com.mizhi.yxd.tools;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * @author yangxudong
 * @description:
 * @date 2021/6/16 21:53
 */
@Slf4j
public class ObjectIsNullUtil {

    public static boolean checkFieldAllNull(Object object) {
        if (null == object) {
            return true;
        }
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            log.error("objectIsNullUtil error, message is :{}", e.getMessage());
        }
        return true;
    }
}
