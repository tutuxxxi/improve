package com.gfr.improve.dao;

import com.gfr.improve.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Course)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-18 13:47:46
 */
public interface CourseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cId 主键
     * @return 实例对象
     */
    Course queryById(String cId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Course> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param course 实例对象
     * @return 对象列表
     */
    List<Course> queryAll(Course course);

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int insert(Course course);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Course> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Course> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Course> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Course> entities);

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 影响行数
     */
    int update(Course course);

    /**
     * 通过主键删除数据
     *
     * @param cId 主键
     * @return 影响行数
     */
    int deleteById(String cId);

    /**
     * 计算数据总数
     * @return
     */
    Integer count();


    /**
     * 模糊查询
     * @param value
     * @param offset
     * @param limit
     * @return
     */
    List<Course> queryByLike(String value, Integer offset, Integer limit);

    /**
     * 模糊查询数据量
     * @param value
     * @return
     */
    Integer countByLike(String value);

    /**
     * 查询所有不重复的keyword作为导航栏内容
     * @return
     */
    List<String> queryAllKeyword();
}