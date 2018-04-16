package com.ztx.action;

import com.ztx.entity.t_User;
import com.ztx.service.t_UserService;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.*;

import javax.annotation.Resource;


/**
 * Created by Think on 2016/10/19.
 */

@ExceptionMappings( { @ExceptionMapping(exception = "java.lang.RuntimeException", result = "error") })
@Results({@Result(name="error", location="/error.jsp")})
@ParentPackage("struts-default")
@Namespace("/")
public class t_UserAction {
	private static final Logger log= Logger.getLogger(t_UserAction.class);

	@Resource(name = "t_UserService")
	private t_UserService t_userService;

	private String id;
	private t_User t_user;

	@Action(value ="tlogin",results = {@Result(location = "/WEB-INF/jsp/testAny.jsp")})
	public String t_login(){

		try {                                                  //ctrl+ Alt +t快捷键 try catch块
			log.info("进入t_login方法");
			t_user = t_userService.selectById(id);
			log.info("执行结束");
			System.out.println("输出的东西" + t_user.getPwd());    //sout快捷键 Tab

		} catch (Exception e) {
			e.printStackTrace();

		}


		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
