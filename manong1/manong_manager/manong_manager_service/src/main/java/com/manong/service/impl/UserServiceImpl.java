package com.manong.service.impl;

import com.manong.mapper.UserMapper;
import com.manong.pojo.User;
import com.manong.pojo.UserExample;
import com.manong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试
 *
 * @author APPLE
 * @author 2019-4-20 下午9:47
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserById(Integer id) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);


        List<User> list = userMapper.selectByExample(userExample);
        if(list!=null){
            return list.get(0);
        }
        return null;
    }

//    @Autowired
//    UserMapper userMapper;
//
//    @Override
//    public User getUserById(Integer id) {
//
//        UserExample userExample = new UserExample();
//        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andIdEqualTo(id);
//
//        List<User> userList = userMapper.selectByExample(userExample);
//
//        if(userList!=null){
//            return userList.get(0);
//        }
//        return null;
//    }
}
