package com.xuedu.edu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value="TestUser",description="测试用户表")
@SuppressWarnings("serial")
public class TestUser implements Serializable{

	@ApiModelProperty(value="用户id")
    private String id;

    @ApiModelProperty(value="用户名")
    private String userName;

    @ApiModelProperty(value="密码")
    private String userPwd;

    @ApiModelProperty(value="创建时间")
    private Date createAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
