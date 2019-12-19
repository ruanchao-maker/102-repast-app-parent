package com.repast.item.app.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ：one group
 * @date ：Created in 2019/12/18 21:19
 * @description ：
 *
 *      分页类封装
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//链条式调用
@Accessors(chain = true)
public class PageInfos<T> {

    /**
     * 当前页数
     */
    private Integer pageNum;

    /**
     * 每一页显示条数
     */
    private Integer pageSize;

    /**
     * 所需要返回的数据
     */
    private T t;

}
