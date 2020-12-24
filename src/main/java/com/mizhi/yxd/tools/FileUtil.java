package com.mizhi.yxd.tools;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/24 22:04
 */
public class FileUtil {
    public static void download(String filename, HttpServletResponse res) throws IOException {
        // 发送给客户端的数据
        OutputStream outputStream = res.getOutputStream();
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        // 读取filename
        ClassPathResource classPathResource =  new ClassPathResource("download"+File.separator+filename);
        InputStream inputStream = classPathResource.getInputStream();
        bis = new BufferedInputStream(inputStream);
        int i = bis.read(buff);
        while (i != -1) {
            outputStream.write(buff, 0, buff.length);
            outputStream.flush();
            i = bis.read(buff);
        }
    }
}
