package cn.guchh.alldocumentsharing.controller;

import cn.guchh.alldocumentsharing.entity.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenhuigu
 */
public abstract class BaseController {
    static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    public BaseController(){

    }

    protected ResponseModel buildResponseModel(String code,String message,Object data){
        ResponseModel model = new ResponseModel();
        model.setCode(code);
        model.setMessage(message);
        model.setData(data);
        return model;
    }
}
