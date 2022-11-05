package cn.guchh.alldocumentsharing.entity;

import lombok.Data;

@Data
public class ResponseModel {

    private String code;
    private String message;
    private Object data;

    public ResponseModel(){

    }

    public ResponseModel(String code,String message){
        this.code = code;
        this.message = message;
        data = null;
    }

    public static ResponseModel success(Object data){
        ResponseModel model = new ResponseModel();
        model.setCode("00000000");
        model.setMessage("响应成功");
        model.setData(data);
        return model;
    }

}
