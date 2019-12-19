package com.repast.item.app.base;

import com.repast.item.app.status.LoginStatus;
import org.springframework.stereotype.Controller;
import sun.rmi.server.LoaderHandler;

/**
 * @author ：one group
 * @date ：Created in 2019/12/18 19:26
 * @description ：
 *
 *      统一使用controller返回
 *      以后所有的controller都必须继承BaseController
 */
@Controller
public class BaseController {

    /**
     * create by: Ruan
     * description:
     *           统一返回值，登陆成功后，使用系统消息返回
     * create time: 2019/12/18 19:29
     *
     * @Param: null
     * @return
     */
    protected ResultData success(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * create by: Ruan
     * description:
     *           统一返回值，登陆成功后，自定义返回消息
     * create time: 2019/12/18 19:29
     *
     * @Param: null
     * @return
     */
    protected ResultData success(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * create by: Ruan
     * description:
     *           统一返回值，登陆成功后，使用系统消息返回并返回数据
     * create time: 2019/12/18 19:29
     *
     * @Param: null
     * @return
     */
    protected ResultData success(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * create by: Ruan
     * description:
     *           统一返回值，登陆成功后，自定义返回消息并且返回结果
     * create time: 2019/12/18 19:29
     *
     * @Param: null
     * @return
     */
    protected ResultData success(Object data,String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }


    /**
     * create by: Ruan
     * description:
     *          登陆失败，返回系统消息
     * create time: 2019/12/18 19:35
     *
      * @Param: null
     * @return 
     */
    protected ResultData failed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        return resultData;
    }




}
