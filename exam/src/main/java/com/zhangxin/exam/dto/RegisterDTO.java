//注册时前端传回的参数
package com.zhangxin.exam.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String email;
    private String password;
    private String password2;
    private String mobile;
    private String captcha;
}
