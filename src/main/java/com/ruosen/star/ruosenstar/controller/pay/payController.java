package com.ruosen.star.ruosenstar.controller.pay;

import com.ruosen.star.ruosenstar.utils.PayCommonUtil;
import com.ruosen.star.ruosenstar.utils.ZxingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

@Controller
@RequestMapping("/wechat")
@Slf4j
public class payController implements Serializable {

    String orderId = new Random().nextInt(999999999) + "";

    @GetMapping("/test")
    @ResponseBody
    public void test(){
        WebSocket.sendMessage(orderId,"支付成功");
    }

    @Autowired
    private PayCommonUtil payCommonUtil;

    @PostMapping("/paysubmit")
    public String paysubmit(String name, Model model, HttpServletRequest request){
        log.info("name:{}",name);
        // 获取需要购买的商品
        // 生产订单号

        // 价格
        String price = "1";
        BufferedImage image = null;
        try {
            String result = payCommonUtil.weixinPay(price, name, orderId);
            // 生产二维码
            image = ZxingUtil.createImage(result, 300, 300);
        } catch (Exception e) {
            log.error("Exception:",e);
        }
        // 跳转到支付页面，显示二维码
        request.getSession().setAttribute("image",image);
        model.addAttribute("orderId",orderId);
        return "payment";
    }


    @GetMapping("/getImg")
    public void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedImage image = (BufferedImage)request.getSession().getAttribute("image");
        ImageIO.write( image,"jpg",response.getOutputStream());
    }
}
