
package com.ct.sbms.Controller;

import com.ct.sbms.entity.User;
import com.ct.sbms.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserConroller
 * @Description TODO
 * @Author caoti
 * @Date 2019/7/13 16:19
 * @since Jdk 1.8
 **/
@Controller
public class UserConroller {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser(){
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @GetMapping("/findUserByPage")
    @ResponseBody
    public PageInfo<User> findPage(){
        PageHelper.startPage(1,2);
        return new PageInfo<>(userMapper.selectAllUser());
    }

    @GetMapping("/user")
    @ResponseBody
    public User user(){
        User user = userMapper.selectByPrimaryKey(1);
        return user;
    }


}
