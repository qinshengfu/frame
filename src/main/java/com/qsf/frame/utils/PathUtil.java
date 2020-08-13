package com.qsf.frame.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 路径的处理
 * @Author QSF
 * @Date 2020/8/13 10:56
 * @Version 1.0
 */
@Configuration
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    private static String os = System.getProperty("os.name");

    private static String winImagePath;

    private static String linuxImagePath;

    private static String winBackupPath;

    private static String linuxBackupPath;

    private static String epImagePath;

    @Value("${win.base.image.path}")
    public void setWinImagePath(String winImagePath) {
        PathUtil.winImagePath = winImagePath;
    }
    @Value("${linux.base.image.path}")
    public void setLinuxImagePath(String linuxImagePath) {
        PathUtil.linuxImagePath = linuxImagePath;
    }
    @Value("${win.base.backup.path}")
    public void setWinBackupPath(String winBackupPath) {
        PathUtil.winBackupPath = winBackupPath;
    }
    @Value("${linux.base.backup.path}")
    public void setLinuxBackupPath(String linuxBackupPath) {
        PathUtil.linuxBackupPath = linuxBackupPath;
    }
    @Value("${ep.relevant.path}")
    public void setEpImagePath(String epImagePath) {
        PathUtil.epImagePath = epImagePath;
    }

    /**
     * 上传凭证图片的存储路径
     * @return
     */
    public static String getImgBasePath() {
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = winImagePath;
        } else {
            basePath = linuxImagePath;
        }
//        basePath = basePath.replace("/", seperator);
        return basePath;
    }
    //获取某个会员（卖家）的相对路径

    public static String getEpImagePath(long userId) {
        String imagePath = epImagePath + userId +seperator;
        return imagePath;
    }

    /*public static String getEpImagePath(long userId) {
        String imagePath = "/upload/images/item/pz/" + userId + "/";
//        return imagePath.replace("/", seperator);
        return imagePath;
    }*/

    /**
     * 备份数据库的存储路径
     * @return
     */
    public static String getBasePath() {
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = winBackupPath;
        } else {
            basePath = linuxBackupPath;
        }
//        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getBackUpAndRestoreBasePath() {
//        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "cmd /c";
        } else {
            basePath = "/bin/sh, -c";
        }
        return basePath;
    }
}
