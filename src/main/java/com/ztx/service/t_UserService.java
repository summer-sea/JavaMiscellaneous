package com.ztx.service;

import com.ztx.entity.t_User;

/**
 * Created by Think on 2016/10/19.
 */
public interface t_UserService {

	/**
	 * Select by id t user.
	 *
	 * @param id the id
	 * @return the t user
	 */
	t_User selectById(String id);



}
