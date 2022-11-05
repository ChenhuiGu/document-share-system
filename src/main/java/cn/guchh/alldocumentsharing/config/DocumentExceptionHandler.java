package cn.guchh.alldocumentsharing.config;


import cn.guchh.alldocumentsharing.entity.ResponseModel;
import cn.guchh.alldocumentsharing.exception.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenhuigu
 */
@ControllerAdvice
@Slf4j(topic = "DocumentExceptionHandler")
public class DocumentExceptionHandler {

    @ExceptionHandler(value = DocumentException.class)
    @ResponseBody
    public ResponseModel exceptionHandler(DocumentException e) {
        return new ResponseModel();
    }
}
