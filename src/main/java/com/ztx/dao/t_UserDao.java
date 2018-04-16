package com.ztx.dao;

import com.ztx.entity.t_User;

/**
 * Created by Think on 2016/10/19.
 */
public interface t_UserDao {

	 t_User selectById(String id);
}
