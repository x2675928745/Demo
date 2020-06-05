package com.xuedu.edu.service.impl;

import com.xuedu.edu.dao.ITestUserDao;
import com.xuedu.edu.pojo.TestUser;
import com.xuedu.edu.pojo.vo.PageVO;
import com.xuedu.edu.service.ITestUserService;
import com.xuedu.edu.utlis.CommonUtil;
import com.xuedu.edu.utlis.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dwen
 * @description 用户-service
 * @create 2020年06月04 14:24
 **/
@Service
public class TestUserServiceImpl implements ITestUserService {

    @Autowired
    private ITestUserDao testUserDao;

    @Override
    public PageVO<TestUser> selectUserPage(int pageIndex) {
        PageVO<TestUser> vo = new PageVO<>();
        List<TestUser> list = this.testUserDao.selectUserPage(CommonUtil.getPageOffset(pageIndex), Constants.PAGE_NUM);
        vo.setList(list);
        int count = this.testUserDao.selectUserPageCount();
        vo.setPageSize(count);
        return vo;
    }

    @Override
    public List<TestUser> selectUsers() {
        return this.testUserDao.selectUsers();
    }

    @Override
    public TestUser selectUserById(String id) {
        return this.testUserDao.selectUserId(id);
    }

    @Override
    public int insertUser(String userName, String userPwd) {
        TestUser user = new TestUser();
        user.setId(CommonUtil.generateUUIDString());
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        return this.testUserDao.insertUser(user);
    }

    @Override
    public int updateUser(String id, String userName) {
        TestUser user = new TestUser();
        user.setId(id);
        user.setUserName(userName);
        return this.testUserDao.updateUser(user);
    }

    @Override
    public int delUser(String id) {
        return this.testUserDao.delUser(id);
    }
}
