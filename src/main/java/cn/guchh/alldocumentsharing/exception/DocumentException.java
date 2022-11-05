package cn.guchh.alldocumentsharing.exception;

import cn.guchh.alldocumentsharing.enums.ResponseCode;

/**
 * @author chenhuigu
 */
public class DocumentException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public DocumentException(ResponseCode responseCode){
        errorCode = responseCode.getCode();
        errorMessage = responseCode.getMessage();
    }
}
