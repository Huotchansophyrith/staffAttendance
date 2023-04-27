//package com.staff.staffAttendance.mapper;
//
//import com.staff.staffAttendance.dto.StaffDto;
//import org.apache.ibatis.annotations.*;
//import java.util.List;
//import java.util.Map;
//
//@Mapper
//public interface StaffMapper {
//
////    @Select("SELECT tu.user_seq AS userId,tu.username AS userName, ts.staff_seq,ts.staff_number, ts.full_name,ts.age,ts.gender,ts.email,ts.phone,ts.profile_img,ts.account_status,\n" +
////            "   (SELECT br.name FROM tb_branches br WHERE br.branch_seq = ts.branch_id) AS branch_id,\n" +
////            "   (SELECT tp.pos_name FROM tb_positions tp WHERE tp.pos_seq = ts.pos_id) AS pos_id,\n" +
////            "   (SELECT td.name FROM tb_depart td WHERE td.depart_seq = ts.department_id) AS department_id\n" +
////            "   FROM tb_staffs ts INNER JOIN tb_users tu on ts.staff_seq = tu.staff_id WHERE ts.enabled = TRUE;")
//
//    @Select("SELECT ts.staff_seq,ts.staff_number, ts.full_name,ts.age,ts.gender,ts.email,ts.phone,ts.profile_img,ts.account_status,\n" +
//            "   (SELECT br.name FROM tb_branches br WHERE br.branch_seq = ts.branch_id) AS branch_id,\n" +
//            "   (SELECT tp.pos_name FROM tb_positions tp WHERE tp.pos_seq = ts.pos_id) AS pos_id,\n" +
//            "   (SELECT td.name FROM tb_depart td WHERE td.depart_seq = ts.department_id) AS department_id\n" +
//            "   FROM tb_staffs ts  WHERE ts.enabled = TRUE;")
//    List<Map<String,Object>> findAll();
//
//    @Select("SELECT staff_number from tb_staffs WHERE staff_number = #{staff_number}")
//    String findByStaffNum(String staff_number);
//
//    @Select("SELECT * from tb_staffs WHERE staff_seq = #{staff_seq}")
//    StaffDto findAllById(int staff_seq);
//
//    @Select("SELECT staff_seq from tb_staffs WHERE staff_seq = #{staff_seq}")
//    StaffDto findById(int staff_seq);
//
//    @Insert("INSERT into tb_staffs(staff_number,full_name,age,gender,email,phone,profile_img,account_status,branch_id,pos_id,department_id,adm_id) " +
//            "VALUES(#{staff_number}, #{full_name},#{age},#{gender},#{email},#{phone},#{profile_img},#{account_status},#{branch_id},#{pos_id},#{department_id},#{adm_id})")
//    @ResultMap("com.staff.staffAttendance.mapper.StaffMapper.staffResult")
//    void create(StaffDto staffDto);
//
//    @Update("UPDATE tb_staffs SET staff_number=#{staff_number} ,full_name=#{full_name},age=#{age},gender=#{gender},email=#{email}," +
//            "phone=#{phone},profile_img=#{profile_img},account_status=#{account_status},branch_id=#{branch_id},pos_id=#{pos_id},department_id=#{department_id},adm_id=#{adm_id}" +
//            "WHERE staff_seq =#{staff_seq}")
//    @ResultMap("com.staff.staffAttendance.mapper.StaffMapper.staffResult")
//    void update(StaffDto staffDto);
//
//    @Delete("UPDATE tb_staffs SET enabled=FALSE WHERE staff_seq =#{staff_seq}")
//    int delete(int staff_seq);
//
//    @Select("SELECT ts.branch_id AS branchId,ts.department_id AS departId,ts.pos_id AS posId,\n" +
//            "       (SELECT br.name FROM tb_branches br WHERE br.branch_seq = ts.branch_id ) AS branchName,\n" +
//            "       (SELECT td.name FROM tb_depart td WHERE td.depart_seq = ts.department_id ) AS departName,\n" +
//            "       (SELECT tp.pos_name FROM tb_positions tp WHERE tp.pos_seq = ts.pos_id ) AS posName\n" +
//            "FROM tb_staffs ts WHERE ts.staff_seq = #{staff_seq}")
//    Map<String,Object> findBrDepartPosByStaffId(int staff_seq);
//
//}
