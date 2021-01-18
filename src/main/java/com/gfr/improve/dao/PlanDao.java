package com.gfr.improve.dao;

import com.gfr.improve.entity.Plan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Plan)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-18 13:48:09
 */
public interface PlanDao {

    /**
     * 通过ID查询单条数据
     *
     * @param palnId 主键
     * @return 实例对象
     */
    Plan queryById(String palnId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Plan> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param plan 实例对象
     * @return 对象列表
     */
    List<Plan> queryAll(Plan plan);

    /**
     * 新增数据
     *
     * @param plan 实例对象
     * @return 影响行数
     */
    int insert(Plan plan);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Plan> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Plan> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Plan> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Plan> entities);

    /**
     * 修改数据
     *
     * @param plan 实例对象
     * @return 影响行数
     */
    int update(Plan plan);

    /**
     * 通过主键删除数据
     *
     * @param palnId 主键
     * @return 影响行数
     */
    int deleteById(String palnId);

}