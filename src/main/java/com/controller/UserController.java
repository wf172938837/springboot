package com.controller;

import com.bean.pojo.Users;
import com.dao.UsersDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("apis/user")
@Api(tags = "用户登陆API")
public class UserController {
    @Autowired
    @Qualifier(value="userdao")
    private UsersDao ud;
    @ApiOperation("用户登陆")
    @ApiImplicitParam(name = "user",value = "登录名和密码",required = true)
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(Users user, HttpSession session){
        if(ud.login(user)!=null){
            session.setAttribute("user",user);
            return "index";
        }

        return "login";
    }


}
