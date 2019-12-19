package com.repast.item.app.base;

import lombok.*;

/**
 * @author ：one group
 * @date ：Created in 2019/12/18 19:19
 * @description ：
 *          如果需要使用@Data注解必须添加jar包
 *               <dependency>
 *                 <groupId>org.projectlombok</groupId>
 *                 <artifactId>lombok</artifactId>
 *               </dependency>
 *         lombok:简化了getter和setter方法
 * @Data:就是getter和setter
 *
 *         统一controller的返回值，也就是说所有的controller统一返回ResultData
 *         -->code:代表状态码
 *         -->msg:返回消息
 *         -->detail:详细描述
 *         -->T:所需要返回的属性
 *
 */
@Data@ToString
//默认的构造方法
@NoArgsConstructor
//传参的构造方法
@AllArgsConstructor
//重写的构造方法
@EqualsAndHashCode
public class ResultData<T> {

    private String code;
    private String msg;
    private String detail;
    private T data;

}
