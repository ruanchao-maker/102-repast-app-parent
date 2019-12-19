package com.repast.item.app.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.repast.item.app.page.PageInfos;
import org.apache.ibatis.session.RowBounds;
import org.omg.PortableInterceptor.INACTIVE;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author ：one group
 * @date ：Created in 2019/12/18 20:58
 * @description ：
 *         所有的service都需要依赖于service（只要是简单的单表增删改查都不需要再写了，可以直接调用）
 */
public abstract class BaseService<T> {

    /**
     * create by: Ruan
     * description:
     *          BaseService这个类是需要被所有的service层继承的
     *          继承之后需要实现未被实现的方法
     * create time: 2019/12/18 21:04
     *
      * @Param: null
     * @return 
     */
    public abstract Mapper<T> getMapper();


    /**
     * create by: Ruan
     * description:
     *          新增一条数据
     * create time: 2019/12/18 21:08
     *
      * @Param: null
     * @return 
     */
    public Integer save(T t) throws Exception{
        return getMapper().insert(t);
    }

    /**
     * create by: Ruan
     * description:
     *          t对象至少有一个值（id）
     *          根据主键更新数据
     * create time: 2019/12/18 21:09
     *
      * @Param: null
     * @return 
     */
    public Integer update(T t) throws Exception{
        return getMapper().updateByPrimaryKey(t);
    }

    /**
     * create by: Ruan
     * description:
     *          根据主键进行删除
     * create time: 2019/12/18 21:10
     *
      * @Param: null
     * @return
     */
    public Integer deleteByPrimaryKey(Object key) throws Exception{
        return getMapper().deleteByPrimaryKey(key);
    }

    /**
     * create by: Ruan
     * description:
     *          根据实体类的属性进行删除
     * create time: 2019/12/18 21:11
     *
      * @Param: null
     * @return
     */
    public Integer deleteByModel(T t) throws Exception{
        return getMapper().deleteByExample(t);
    }

    /**
     * create by: Ruan
     * description:
     *          通过主键查询数据
     * create time: 2019/12/18 21:12
     *
      * @Param: null
     * @return 
     */
    public T selectById(Object key) throws Exception{
        return getMapper().selectByPrimaryKey(key);
    }

    /**
     * create by: Ruan
     * description:
     *          查询所有数据
     * create time: 2019/12/18 21:13
     *
      * @Param: null
     * @return 
     */
    public List<T> selectAll() throws Exception{
        return getMapper().selectAll();
    }

    /**
     * create by: Ruan
     * description:
     *          根据属性确定一条数据（必须要有唯一键）
     *          或者是能通过几个属性来确定一条数据(有且只有一条数据)
     * create time: 2019/12/18 21:14
     *
      * @Param: null
     * @return 
     */
    public T selectByModel(T t) throws Exception{
        return getMapper().selectOne(t);
    }

    /**
     * create by: Ruan
     * description:
     *          通过属性查询数据返回多条数据
     * create time: 2019/12/18 21:16
     *
      * @Param: null
     * @return
     */
    public List<T> selectByModeCondidation(T t) throws Exception{
        return getMapper().select(t);
    }

    /**
     * create by: Ruan
     * description:
     *          带条件查询的分页
     *          t:代表条件查询
     *          先进性条件查询--->List(100)-->进行分页(5)
     * create time: 2019/12/18 21:22
     *
      * @Param: null
     * @return
     */
    public List<T> selectPage(T t, PageInfos<T> pageInfos) throws Exception{
        return getMapper().selectByRowBounds(t,new RowBounds(pageInfos.getPageNum(),pageInfos.getPageSize()));
    }

    /**
     * create by: Ruan
     * description:
     *         待条件查询所有条数
     *         select count(1) from user where username like '%zhang%';
     *         如果需要查询所有条数直接传入null（缺省，如果缺省则直接表示查询所有）
     * create time: 2019/12/18 21:25
     *
      * @Param: null
     * @return 
     */
    public Integer selectCount(T t)throws Exception{
        return getMapper().selectCount(t);
    }

    
    /**
     * create by: Ruan
     * description:
     *          带条件分页查询
     * create time: 2019/12/18 21:33
     *
      * @Param: null
     * @return 
     */
    public PageInfo<T> selectPageInfo(PageInfos<T> pageInfos) throws Exception{
        //1.首先判断pageNum是否等于空--->如果等于空则说明是第一个访问
        if (pageInfos.getPageNum() == null){
            pageInfos.setPageNum(0);
        }
        //2.直接使用pageHelper进行分页
        //select * from user limit() 0,3
        PageHelper.startPage(pageInfos.getPageNum(),pageInfos.getPageSize());
        //查询所有的数据并返回所有数据的集合(但是没有分页)
        List<T> tList = this.selectByModeCondidation(pageInfos.getT());
        //实现list集合的分页
        PageInfo<T> pageInfo = new PageInfo<T>(tList);
        pageInfo.setTotal(this.selectCount(pageInfos.getT()));
        return pageInfo;
    }

}
