package com.ssyx.common.exception;

import com.ssyx.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author gray
 * @date 13/07/2025
 * @description 自定义异常类
 */
@Data
public class ServiceException extends RuntimeException {

    //异常状态码
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     *
     * @param message
     * @param code
     */
    public ServiceException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     *
     * @param resultCodeEnum
     */
    public ServiceException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
