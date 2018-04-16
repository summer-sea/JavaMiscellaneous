package com.ztx.service.impl;

import com.ztx.dao.t_UserDao;
import com.ztx.entity.t_User;
import com.ztx.service.t_UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Think on 2016/10/19.
 */
@Service(value = "t_UserService")
public class t_UserServiceImpl implements t_UserService {

	@Resource(name = "t_UserDao")
	protected t_UserDao t_userDao;

	@Override
	public t_User selectById(String id) {

		return t_userDao.selectById(id);
	}
}
