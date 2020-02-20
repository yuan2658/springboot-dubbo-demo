package com.example.demo.service;

import com.example.demo.entity.VideoCatory;
import java.util.List;

/**
 * (VideoCatory)表服务接口
 *
 * @author makejava
 * @since 2020-02-19 23:00:45
 */
public interface VideoCatoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VideoCatory queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<VideoCatory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param videoCatory 实例对象
     * @return 实例对象
     */
    VideoCatory insert(VideoCatory videoCatory);

    /**
     * 修改数据
     *
     * @param videoCatory 实例对象
     * @return 实例对象
     */
    VideoCatory update(VideoCatory videoCatory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}