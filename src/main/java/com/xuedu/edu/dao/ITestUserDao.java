package com.xuedu.edu.dao;
/**
 * 用户Demo - Dao
 * @author dwen
 * 2020年5月17日下午4:07:13
 */
import com.xuedu.edu.pojo.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.ResolverUtil;

import java.util.List;

@Mapper
public interface ITestUserDao {

	/**
	 * 用户列表-分页
	 * @return
	 */
	List<TestUser> selectUserPage(@Param("offset") int offset, @Param("size") int size);
	/**
	 * 用户列表-分页-Count
	 * @return
	 */
	int selectUserPageCount();

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
	TestUser selectUserId(@Param("id") String id);

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int insertUser(TestUser user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int delUser(@Param("id") String id);
	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	int  updateUser(TestUser user);


}
