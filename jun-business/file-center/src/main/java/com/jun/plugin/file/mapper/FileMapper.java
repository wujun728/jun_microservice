package com.jun.plugin.file.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

//import com.jun.plugin.file.model.FileInfo;
import com.jun.plugin.db.mapper.SuperMapper;
import com.jun.plugin.file.model.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 上传存储db
 *
 * @author zlt
 */
@Mapper
public interface FileMapper extends SuperMapper<FileInfo> {
    List<FileInfo> findList(Page<FileInfo> page, @Param("f") Map<String, Object> params);
}
