package com.wzlt.restaurantdian.common;

import com.wzlt.restaurantdian.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Entering Login Interceptor");

        // 获取当前会话
        HttpSession session = request.getSession(false);

        // 检查会话中是否存在用户信息
        User user = (User) session.getAttribute("user");

        if (user != null) {
            // 用户已登录，允许请求继续执行
            return true;
        } else {
            // 用户未登录，拒绝请求并返回JSON响应提示用户需先登录
            logger.warn("User is not logged in, access denied");
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"请先登录\"}");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置状态码为401（Unauthorized）
            return false;
        }
    }
}
