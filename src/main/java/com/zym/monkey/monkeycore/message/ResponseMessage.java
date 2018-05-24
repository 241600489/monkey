package com.zym.monkey.monkeycore.message;

import java.util.Map;

/**
 * @author 梁自强
 * @date 2018/5/21 16:18
 * @desc 主要用于返回给客户端的消息类
 */
public class ResponseMessage {
    /*返回的状态，默认为200*/
    private Integer status = 200;
    /*提示信息，比如保存成功之类*/
    private String message;
    /*存储返回的数据*/
    private Map<String, Object> data;
    private MonkeyErrorMsg errorMsg;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public MonkeyErrorMsg getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(MonkeyErrorMsg errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", errorMsg=" + errorMsg +
                '}';
    }
}
