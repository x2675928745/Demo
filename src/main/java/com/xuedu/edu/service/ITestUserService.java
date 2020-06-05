package com.xuedu.edu.service;

import com.xuedu.edu.pojo.TestUser;
import com.xuedu.edu.pojo.vo.PageVO;

import java.util.List;

/**
 * 后台用户
 * @author dwen
 *	2018年11月21日 下午10:18:24
 */
public interface ITestUserService {
	/**
	 * 用户列表-分页
	 * @return
	 */
	PageVO<TestUser> selectUserPage(int pageIndex);
	/**
	 * 用户列表
	 * @return
	 */
	List<TestUser> selectUsers();

	/**
	 * 查询当前用户
	 * @param id
	 * @return
	 */
	TestUser selectUserById(String id);

	/**
	 * 添加用户
	 * @return
	 */
	int insertUser(String userName,String userPwd);
	/**
	 * 编辑用户
	 * @param userName
	 * @return
	 */
	int  updateUser(String id,String userName);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int delUser(String id);

	
}
