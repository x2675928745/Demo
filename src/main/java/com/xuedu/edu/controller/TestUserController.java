package com.xuedu.edu.controller;

import com.xuedu.edu.pojo.TestUser;
import com.xuedu.edu.pojo.vo.PageVO;
import com.xuedu.edu.service.ITestUserService;
import com.xuedu.edu.utlis.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(value = "*",maxAge = 3600)
@Api(value="用户-Controller",tags= {"用户管理"})
@RestController
@RequestMapping("api/user/{userId}/test")
public class TestUserController {
	
	@Autowired
	private ITestUserService testUserService;

	@ApiOperation(value = "用户管理接口",response= TestUser.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "x-access-token",required = true, value="token"),
			@ApiImplicitParam(paramType = "path", name = "userId", value = "用户id：0", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "pageIndex", value = "分页：1", required = true, dataType = "int"),
	})
	@GetMapping("selectUserPage")
	public String selectUserPage(
			@RequestHeader("x-access-token") String token,
			@PathVariable("userId") String userId,
			@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex) {
		PageVO<TestUser> admins = this.testUserService.selectUserPage(pageIndex);
		return ResultUtil.OK(admins);
	}
	
	@ApiOperation(value = "查询所有用户接口",response=TestUser.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "x-access-token",required = true, value="token"),
			@ApiImplicitParam(paramType = "path", name = "userId", value = "用户id：0", required = true, dataType = "String"),
	})
	@GetMapping("selectUsers")
	public String selectUsers(
			@RequestHeader("x-access-token") String token,
			@PathVariable("userId") String userId) {
		List<TestUser> admins = this.testUserService.selectUsers();
		return ResultUtil.OK(admins);
	}
	
	@ApiOperation(value = "用户详细接口",response=TestUser.class,notes="用户详细接口")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "x-access-token",required = true, value="token"),
			@ApiImplicitParam(paramType = "path", name = "userId", value = "用户id：0", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "id", value = "需查询用户id", required = true, dataType = "String"),
	})
	@GetMapping("selectUserById")
	public String selectUserById(
			@RequestHeader("x-access-token") String token,
			@PathVariable("userId") String userId,
			@RequestParam("id") String id) {
		TestUser admins = this.testUserService.selectUserById(id);
		return ResultUtil.OK(admins);
	}
	
	@ApiOperation(value = "添加用户接口",response=Integer.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "x-access-token",required = true, value="token"),
			@ApiImplicitParam(paramType = "path", name = "userId", value = "用户id：0", required = true, dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "userName", value = "用户名", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "userPwd", value = "密码", required = true, dataType = "String"),
	})
	@PostMapping("addUser")
	public String addUser(
			@RequestHeader("x-access-token") String token,
			@PathVariable("userId") int userId,
			@RequestParam("userName") String userName,
			@RequestParam("userPwd") String userPwd) {
		int result = this.testUserService.insertUser(userName,userPwd);
		return ResultUtil.OK(result);
	}
	
	@ApiOperation(value = "编辑用户接口",response=Integer.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "x-access-token",required = true, value="token"),
			@ApiImplicitParam(paramType = "path", name = "userId", value = "用户id：0", required = true, dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "id", value = "id", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "userName", value = "用户名", required = true, dataType = "String"),
	})
	@PostMapping("updateUser")
	public String updateUser(
			@RequestHeader("x-access-token") String token,
			@PathVariable("userId") int userId,
			@RequestParam("id") String id,
			@RequestParam("userName") String userName) {
		int result = this.testUserService.updateUser(id,userName);
		return ResultUtil.OK(result);
	}
	
	@ApiOperation(value = "删除用户接口",response=Integer.class)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "x-access-token",required = true, value="token"),
			@ApiImplicitParam(paramType = "path", name = "userId", value = "用户id：0", required = true, dataType = "String"),
			@ApiImplicitParam(paramType = "query", name = "id", value = "id", required = true, dataType = "String"),
	})
	@PostMapping("delUser")
	public String delUser(
			@RequestHeader("x-access-token") String token,
			@PathVariable("userId") String userId,
			@RequestParam("id") String id) {
		int result = this.testUserService.delUser(id);
		return ResultUtil.OK(result);
	}
	

}
