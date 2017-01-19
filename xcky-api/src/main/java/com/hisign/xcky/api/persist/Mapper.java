/**
 *
 */
package com.hisign.xcky.api.persist;

import java.util.List;

/**
 * 持久层接口基类
 *
 * @author chailiangzhi
 * @date 2015-10-13
 */
public interface Mapper<T> {

    /**
     * 根据ID或者唯一条件查询
     *
     * @param id
     * @return
     */
    public T getById(String id);

    /**
     * 返回分页后的数据
     *
     * @param t
     * @return
     */
    public List<T> query(T t);

    /**
     * 根据id删除记录（物理删除）
     *
     * @param id
     */
    public void deleteById(String id);

    /**
     * 根据id删除记录（逻辑删除）
     *
     * @param t
     */
    public int deleteLogicById(T t);

    /**
     * 根据记录id更新记录
     *
     * @param t
     */
    public int updateById(T t);

    /**
     * 新增记录
     *
     * @param t
     */
    public void add(T t);

    /**
     * 批量新增
     *
     * @param list
     */
    public void addBatch(List<T> list);

}
