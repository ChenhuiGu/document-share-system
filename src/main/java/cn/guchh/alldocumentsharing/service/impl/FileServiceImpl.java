package cn.guchh.alldocumentsharing.service.impl;

import cn.guchh.alldocumentsharing.entity.FileDocument;
import cn.guchh.alldocumentsharing.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author chenhuigu
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public FileDocument saveFile(String md5, MultipartFile file) {

    }
}
