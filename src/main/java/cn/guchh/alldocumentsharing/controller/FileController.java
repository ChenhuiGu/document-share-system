package cn.guchh.alldocumentsharing.controller;

import cn.guchh.alldocumentsharing.entity.FileDocument;
import cn.guchh.alldocumentsharing.entity.ResponseModel;
import cn.guchh.alldocumentsharing.exception.DocumentException;
import cn.guchh.alldocumentsharing.service.FileService;
import cn.hutool.crypto.SecureUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import cn.guchh.alldocumentsharing.enums.ResponseCode;

/**
 * @author chenhuigu
 */
@Slf4j
@RequestMapping("files")
@RestController
public class FileController extends BaseController{
    @Autowired
    FileService fileService;

    @GetMapping("/list")
    public ResponseModel list(@RequestParam("pageIndex") Integer pageIndex,
                              @RequestParam("pageSize") Integer pageSize){
        List<FileDocument> fileDocuments = fileService.listFileByPage(pageIndex, pageSize);
        return ResponseModel.success(fileDocuments);
    }


    @PostMapping("/upload")
    public ResponseModel formUpload(@RequestParam("file") MultipartFile file) {
        List<String> availableSuffixList = Lists.newArrayList("pdf", "png", "docx", "pptx", "xlsx");
        String fileMd5 = "";
        try {
            if (file != null && !file.isEmpty()) {
                String originFileName = file.getOriginalFilename();
                if (!StringUtils.hasText(originFileName)) {
                    throw new DocumentException(ResponseCode.FILE_TYPE_ERROR);
                }
                String suffix = originFileName.substring(originFileName.lastIndexOf(".") + 1);
                if(!availableSuffixList.contains(suffix)) {
                    throw new DocumentException(ResponseCode.FILE_TYPE_ERROR);
                }
                fileMd5 = SecureUtil.md5(file.getInputStream());
                log.info("file id:{} upload",fileMd5);
                FileDocument fileDocument = fileService.saveFile(fileMd5, file);
                //TODO ES上传
                return buildResponseModel(ResponseCode.FILE_UPLOAD_SUCCESS.getCode(),
                        ResponseCode.FILE_UPLOAD_SUCCESS.getMessage(), fileDocument.getId());
            } else {
                throw new DocumentException(ResponseCode.FILE_EMPTY);
            }
        } catch (Exception ex) {
            log.error("file id:{} upload fail",fileMd5);
            throw new DocumentException(ResponseCode.FILE_UPLOAD_FAIL);
        }
    }

}
