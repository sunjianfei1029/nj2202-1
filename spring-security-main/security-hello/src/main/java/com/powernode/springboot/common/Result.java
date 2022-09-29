package com.powernode.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 15:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer code;  // 响应码

    private String msg;   // 响应信息

    private Object data;  // 响应的数据

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
