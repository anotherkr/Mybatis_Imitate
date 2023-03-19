package com.yhz.mybatis.dao;

import com.yhz.mybatis.po.User;

public interface IUserDao {

   User queryUserInfoById(Long id);
   User queryUserInfo(User user);

}