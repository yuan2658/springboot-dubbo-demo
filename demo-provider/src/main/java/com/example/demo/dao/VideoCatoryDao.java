package com.example.demo.dao;

import com.example.demo.entity.VideoCatory;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (VideoCatory)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-19 23:00:45
 */
public interface VideoCatoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VideoCatory queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<VideoCatory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param videoCatory 实例对象
     * @return 对象列表
     */
    List<VideoCatory> queryAll(VideoCatory videoCatory);

    /**
     * 新增数据
     *
     * @param videoCatory 实例对象
     * @return 影响行数
     */
    int insert(VideoCatory videoCatory);

    /**
     * 修改数据
     *
     * @param videoCatory 实例对象
     * @return 影响行数
     */
    int update(VideoCatory videoCatory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}