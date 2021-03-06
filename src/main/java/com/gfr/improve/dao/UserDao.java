package com.gfr.improve.dao;

import com.gfr.improve.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-18 13:48:29
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<User> entities);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(String userId);


    /**
     * 查询用户数量
     * @return 用户数量
     */
    int queryUserNum();

    /**
     * 模糊查询
     * @param value
     * @param page
     * @param limit
     * @return
     */
    List<User> queryByLike(String value, Integer page, Integer limit);

    /**
     * 模糊查询的结果数量
     * @param value
     * @return
     */
    int countByLike(String value);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    User queryByUsernamePwd(User user);

    int addSportTime(String userId, Integer sportTime);

    User queryByUsernameTel(User user);
}