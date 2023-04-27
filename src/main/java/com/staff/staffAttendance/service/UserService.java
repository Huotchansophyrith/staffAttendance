//package com.staff.staffAttendance.service;
//
//import com.staff.staffAttendance.mapper.UserMapper;
//import com.staff.staffAttendance.model.UserModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    /**
//     * Load user by username user model.
//     *
//     * @param username the username
//     * @return the user model
//     */
//    public UserModel loadUserByUsername(String username) {
//        return userMapper.getUserByUsername(username);
//    }
//
//    /**
//     * Load user by username and password user model.
//     *
//     * @param username the username
//     * @param password the password
//     * @return the user model
//     */
//    public UserModel loadUserByUsernameAndPassword(String username, String password) {
//        return userMapper.getUserByUsernameAndPassword(username, password);
//    }
//
//}
