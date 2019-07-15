package com.dao;

import com.bean.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public interface UsersDao {

    public Users login(Users user);
}
