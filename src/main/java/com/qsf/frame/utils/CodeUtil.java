package com.qsf.frame.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断验证码是否相等
 * @Author QSF
 * @Date 2020/8/13 10:58
 * @Version 1.0
 */
public class CodeUtil {
    /**
     * 检查验证码是否和预期相符
     *
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request, String verifyCodeActual) {
        String verifyCodeExpected = (String) request.getSession()
                .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
