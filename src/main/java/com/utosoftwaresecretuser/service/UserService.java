package com.utosoftwaresecretuser.service;

import com.utosoftwaresecretuser.domain.Role;
import com.utosoftwaresecretuser.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User GetUser(String username);
    List<User> getUsers();

}
