package com.springboot.demo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApiModel("响应信息")
public class ResponseMsg implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8862689009919594048L;

    protected static Logger logger=LoggerFactory.getLogger(ResponseMsg.class);

    @ApiModelProperty("返回编码")
    private int code;//返回编码

    @ApiModelProperty("错误提示")
    private String msg = "";//错误提示

    @ApiModelProperty("返回数据")
    private Object data ;//返回数据

    @ApiModelProperty("缓存数据")
    private String ticket;// 缓存ticket

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public ResponseMsg setError(String str) {
        this.setCode(-1);
        this.setMsg(str);
        return this;
    }
    public ResponseMsg setError(int code,String str) {
        this.setCode(code);
        this.setMsg(str);
        return this;
    }
    public ResponseMsg setError(Throwable e) {
        logger.info(e.toString());
        this.setCode(-1);
        if(e.getMessage() !=null &&e.getMessage().length()!=e.getMessage().getBytes().length && e.getMessage().length() < 50){
            this.setMsg(e.getMessage());
        }else if(e.getMessage() ==null){
            this.setMsg("程序出错,请联系客服");
        }else{
            this.setMsg("程序出错,请联系客服");
        }
        this.setData(null);
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

