package com.mizhi.yxd.tools;

import com.mizhi.yxd.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangxudong
 * @description:
 * @date 2021/6/16 22:07
 */
@Component
public class SemesterUtil {
    @Autowired
    private SemesterService semesterService;

    public boolean ifContain(String message) {
        return semesterService.contains(message);
    }
}
