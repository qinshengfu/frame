package com.qsf.frame.utils;

import com.qsf.frame.dto.ImageHolder;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author QSF
 * @Date 2020/8/13 10:55
 * @Version 1.0
 */
@Slf4j
public class ImageUtil {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    /**
     * 处理凭证图，并返回新生成图片的相对值路径
     *
     * @param imageHolder
     * @param targetAddr 存储图片的相对路径（判断是否已经存在，没有就创建）
     * @return
     */
    public static String voucherImg(ImageHolder imageHolder, String targetAddr) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(imageHolder.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = targetAddr + realFileName + extension;
        log.debug("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        log.debug("current complete addr is :" + PathUtil.getImgBasePath() + relativeAddr);
        // 调用Thumbnails生成的图片
        try {
            Thumbnails.of(imageHolder.getImage())
                    .scale(1f)
                    .outputQuality(0.5f)
                    .toFile(dest);
        } catch (IOException e) {
            log.error(e.toString());
            throw new RuntimeException("创建缩图片失败：" + e.toString());
        }
        // 返回图片相对路径地址
        return relativeAddr;
    }

    public static void main(String[] args) throws IOException {
        String fName =" G:\\fakepath\\tp\\cs\\20200225181219.jpg ";

        File tempFile =new File( fName.trim());
        //获取文件名
        String fileName = tempFile.getName();

        System.out.println("fileName = " + fileName);

        Thumbnails.of(tempFile)
                .scale(1f)
                .outputQuality(0.5f)
                .toFile(new File("F:\\cstp\\cg\\woshishangchuande.jpg"));

        /*Thumbnails.of(new File("/Users/baidu/work/image/xiaohuangren.jpg")).size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                .outputQuality(0.8f).toFile("/Users/baidu/work/image/xiaohuangrennew.jpg");*/
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/xiangze/xxx.jpg, 那么 home work xiangze
     * 这三个文件夹都得自动创建
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     *
     * @return
     */
    public static String getRandomFileName() {
        // 获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }
}
