package cn.guchh.alldocumentsharing.enums;


public enum ResponseCode {

    FILE_UPLOAD_SUCCESS("10000000","文件上传成功"),

    FILE_TYPE_ERROR("10000021","文件类型错误"),

    FILE_EMPTY("10000022","请上传文件"),

    FILE_UPLOAD_FAIL("10000023","上传文件失败");

    ResponseCode(String code,String message){
        this.code = code;
        this.message = message;
    }
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
