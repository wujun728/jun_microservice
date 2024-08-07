package io.github.wujun728.oauth.service;

import io.github.wujun728.common.model.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jun
 * @date 2018/12/10
 * <p>
 * Blog: https://jun2000.gitee.io
 * Github: https://github.com/jun2000
 */
public interface IValidateCodeService {
    /**
     * 保存图形验证码
     * @param deviceId 前端唯一标识
     * @param imageCode 验证码
     */
    void saveImageCode(String deviceId, String imageCode);

    Result sendSmsCode(String mobile);

    /**
     * 获取验证码
     * @param deviceId 前端唯一标识/手机号
     */
    String getCode(String deviceId);

    /**
     * 删除验证码
     * @param deviceId 前端唯一标识/手机号
     */
    void remove(String deviceId);

    /**
     * 验证验证码
     */
    void validate(String deviceId, String validCode);
}
