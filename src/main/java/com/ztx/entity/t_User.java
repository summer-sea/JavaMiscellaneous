package com.ztx.entity;

import java.util.Date;

/**
 * Created by Think on 2016/10/19.
 */
public class t_User {
	private  String  id;
	private  String  name;
	private  String  pwd;
	private  Date    createDateName;
	private  Date    modifyDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getCreateDateName() {
		return createDateName;
	}

	public void setCreateDateName(Date createDateName) {
		this.createDateName = createDateName;
	}

	public Date getModifyDateTime() {
		return modifyDateTime;
	}

	public void setModifyDateTime(Date modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}
}
