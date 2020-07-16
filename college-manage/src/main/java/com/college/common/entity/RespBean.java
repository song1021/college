package com.college.common.entity;

public class RespBean {
    private Integer status;//状态  200  500
    private String msg;//描述消息
    private Object obj;//返回到前端的数据

    //访问成功时，用改方法构造对象，传递数据
    public static RespBean ok(String msg){
        return new RespBean(200, msg,null);
    }

    public static RespBean ok(String msg, Object obj){
        return new RespBean(200, msg, obj);
    }

    //访问失败时，用改方法构造对象，传递数据
    public static RespBean error(String msg){
        return new RespBean(500, msg,null);
    }

    public static RespBean error(String msg, Object obj){
        return new RespBean(500,msg,obj);
    }

    private RespBean() {
    }

    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
