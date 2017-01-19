package com.hisign.xcky.util;

import org.springframework.util.FileCopyUtils;

import java.io.*;

/**
 * 文件上传工具
 * @author wangping
 * @version 1.0
 * @since 2016/8/16 16:57
 */
public class UploadUtil {

    /**
     * 文件上传
     * @param in
     * @param destFileName
     * @throws Exception
     */
    public static void uploadFile(InputStream in, String destFileName) throws Exception {
        String path = destFileName.substring(0, destFileName.lastIndexOf("\\"));
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
        File file = new File(destFileName);//可以是任何图片格式.jpg,.png等
        FileOutputStream fos = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int nRead = 0;
        while ((nRead = in.read(b)) != -1) {
            fos.write(b, 0, nRead);
        }
        fos.flush();
        fos.close();
        in.close();
    }

    /**
     * 文件上传
     * @param in
     * @param out
     * @throws Exception
     */
    public static void uploadFileAsStream(InputStream in, OutputStream out) throws Exception {
        byte[] b = new byte[1024];
        int nRead = 0;
        while ((nRead = in.read(b)) != -1) {
            out.write(b, 0, nRead);
        }
        out.flush();
        out.close();
        in.close();
    }

    /**
     * 文件上传
     * @param inFile
     * @param out
     * @throws Exception
     */
    public static void uploadFileFromFile(File inFile, OutputStream out) throws Exception {
        FileInputStream fis = new FileInputStream(inFile);
        try {
            FileCopyUtils.copy(fis, out);
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != fis) {
                fis.close();
            }
        }
    }

    /**
     * 二进制文件插入数据库
     * @param bytes 数组对象
     * @param out 输出流
     * @author jiangpeng
     * @throws Exception
     */
    public static void uploadFileFromByte(byte[] bytes, OutputStream out) throws Exception {
        ByteArrayInputStream inStream = new ByteArrayInputStream(bytes);
        try {
            FileCopyUtils.copy(inStream, out);
        } catch (Exception e) {
            throw e;
        } finally {
            inStream.close();
        }
    }

}
