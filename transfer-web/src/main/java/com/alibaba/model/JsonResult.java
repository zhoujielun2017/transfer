package com.alibaba.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 通用返回结果
 * @author ruby
 * @version 2018/7/5
 */
public class JsonResult implements Serializable {
    /**
     *
	 */
	private static final long serialVersionUID = 8104304929896037489L;

	public static final Logger logger = LoggerFactory.getLogger(JsonResult.class);

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String FAIL_MESSAGE = "system.error";
    public static final String SUCCESS_MESSAGE = "success";
    /**
     * 返回代码
     */
    private String code;
    /**
     * 错误信息,根据code从国际化文件里获取
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;

    public JsonResult(){

    }

    public JsonResult(String code) {
        this.code = code;
    }

    public JsonResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 是否成功
     * @return
     */
    public boolean checkSuccess(){
        return SUCCESS.equals(code);
    }

    public static JsonResult success(){
        return new JsonResult(SUCCESS,SUCCESS_MESSAGE,null);
    }

    public static JsonResult success(Object data){
        return new JsonResult(SUCCESS,null,data);
    }

    public static JsonResult success(String message, Object data) {
        return new JsonResult(SUCCESS, message, data);
    }

    public static JsonResult fail(){
        return new JsonResult(FAIL,FAIL_MESSAGE,null);
    }
    public static JsonResult fail(String code){
        return new JsonResult(code,null,null);
    }

    public static JsonResult fail(String code,String msg){
        return new JsonResult(code,msg,null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("msg", msg)
                .append("data", data)
                .toString();
    }
}
