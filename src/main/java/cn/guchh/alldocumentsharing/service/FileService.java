package cn.guchh.alldocumentsharing.service;

import cn.guchh.alldocumentsharing.entity.FileDocument;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author chenhuigu
 */
public interface FileService {

    /**
     * 保存文件 - 表单
     *
     * @param md5
     * @param file
     * @return
     */
    FileDocument saveFile(String md5, MultipartFile file);

    /**
     * 分页获取文档
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<FileDocument> listFileByPage(int pageIndex,int pageSize);
}
