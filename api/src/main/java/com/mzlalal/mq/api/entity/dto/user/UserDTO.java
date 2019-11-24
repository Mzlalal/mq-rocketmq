package com.mzlalal.mq.api.entity.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Mzlalal
 * @date: 2019/11/23 15:19
 * @version: 1.0
 */
@Data
public class UserDTO<T> implements Serializable {
    /**
     * 姓名
     */
    private String username;
    /**
     * 年龄
     */
    private Integer age;
}
