package com.ruosen.star.ruosenstar.rqcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *   zxing二维码
 *  * @projectName ruosen-star
 *  * @title     Zxing_code   
 *  * @package    com.ruosen.star.ruosenstar.rqcode  
 *  * @author Administrator     
 *  * @date   2019/11/3 0003 星期日
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Component
public class ZxingCode {

//    Integer width = 300;
//    Integer height = 300;
//
//    String formart = "png";
//    String content = "ZxingCode 二维码";

    /**
     * 生成二维码
     *
     * @param width
     * @param height
     * @param format
     * @param content
     */
    public void zxingCodeGenerate(Integer width, Integer height, String format, String content) {

        // 二维码参数
        Map<EncodeHintType, Object> map = new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        map.put(EncodeHintType.MARGIN, 2);

        try {
            // 生成二维码到本地磁盘
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, map);
            MatrixToImageWriter.writeToPath(bitMatrix, format, new File("D:\\study\\qrcode\\zxing.png").toPath());
        } catch (Exception e) {
            log.error("生成zxing 二维码失败：", e);
        }
    }

    /**
     * 解析二维码
     *
     * @return
     */
    public Object zxingCodeResolving() {

        MultiFormatReader multiFormatReader = new MultiFormatReader();
        BufferedImage image = null;
        Result result = null;
        try {
            image = ImageIO.read(new File("D:\\study\\qrcode\\zxing.png"));
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

            // 二维码参数
            Map map = new HashMap<>();
            map.put(EncodeHintType.CHARACTER_SET, "utf-8");
            result = multiFormatReader.decode(binaryBitmap, map);

            log.info("解析结果：{}", result.toString());
            log.info("getBarcodeFormat:{}", result.getBarcodeFormat());
            log.info("getText :{}", result.getText());
        } catch (Exception e) {
            log.error("解析二维码失败：", e);
        }

        return result;
    }


}
