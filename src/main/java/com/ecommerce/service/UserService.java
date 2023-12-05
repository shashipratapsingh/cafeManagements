package com.ecommerce.service;

import com.ecommerce.dao.RoleDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.entity.Role;
import com.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    public User RegisterNewUser(User user){
        return this.userDao.save(user);
    }

    public void initRolesAndUser(){
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleDao.save(adminRole);

        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser=new User();
        adminUser.setUserName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin1234");
        Set<Role> adminRoles=new HashSet<>();
        adminUser.setRole(adminRoles);
        adminRoles.add(adminRole);
        userDao.save(adminUser);

        User user=new User();
        user.setUserName("Raj");
        user.setUserLastName("sharma");
        user.setUserName("raj1234");
        Set<Role> userRoles=new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }




}
