package org.zx.blog.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zx.blog.Dao.UserDao;
import org.zx.blog.Model.User;

import java.util.List;

/**
 * UserController
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/findUserByEmail")
    public Object getUserByEmail(String email){
        System.out.println("email:"+email);
        User user = userDao.findByEmail(email);
        if (null==user){
            return "暂无数据";
        }else {
            return user;
        }
    }
    @RequestMapping(value = "/getAll")
    public Object getAllUser(){
        List<User> list = (List<User>) userDao.findAll();
        if (null == list||list.size()==0){
            return "暂无数据";
        }else {
            return list;
        }
    }
    @RequestMapping(value = "/adduser")
    public Object addUser(String name, String email){
        User user  = new User();
        user.setID();
        user.setName(name);
        user.setEmail(email);
        User resultUser = userDao.save(user);
        if (null==resultUser){
            return "新增用户失败";
        }else {
            return "新增用户"+resultUser.getName();
        }
    }

}
