//package com.staff.staffAttendance.mapper;
//
//import com.staff.staffAttendance.common.constant.ResponseDTO;
//import com.staff.staffAttendance.common.exception.RequestException;
//import com.staff.staffAttendance.dto.UserDto;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//@Mapper
//public interface UserCreateMapper {
//
//    /**
//     * Gets user by username.
//     *
//     * @param username the username
//     * @return user by username
//     */
//    UserDto getUserByUsername(String username);
//
//    /**
//     * Gets user by username and password.
//     *
//     * @param username the username
//     * @param password the password
//     * @return the user by username and password
//     */
//    UserDto getUserByUsernameAndPassword(@Param("username") String username,
//                                           @Param("password") String password);
//
//    ResponseDTO create(UserDto userDto) throws RequestException;
//
//}
