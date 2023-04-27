//package com.staff.staffAttendance.mapper;
//
//import com.staff.staffAttendance.dto.CompanyDto;
//import org.apache.ibatis.annotations.*;
//import java.util.List;
//import java.util.Map;
//
//@Mapper
//public interface CompanyMapper {
//
//    @Select("SELECT tc.company_seq,tc.company_name,tc.company_short_name,tc.description\n" +
//            ",(SELECT br.name FROM tb_branches br WHERE br.branch_seq = tc.branch_id) AS branch_id \n" +
//            "FROM tb_companies tc WHERE tc.enabled = TRUE;")
//    List<Map<String,Object>> findAll();
//
//    @Select("SELECT company_name from tb_companies WHERE company_name = #{company_name}")
//    String findByComName(String company_name);
//
//    @Select("SELECT company_seq from tb_companies WHERE company_seq = #{company_seq}")
//    CompanyDto findById(int company_seq);
//
//    @Select("SELECT tc.branch_id AS branchId, (SELECT br.name FROM tb_branches br WHERE br.branch_seq = tc.branch_id) AS branchName FROM tb_companies tc WHERE tc.company_seq = #{company_seq}")
////    @ResultMap("com.staff.staffAttendance.mapper.CompanyMapper.companyResult")
//    Map<String, Object> findBranchNameByComId(int company_seq);
//
//    @Select("SELECT * from tb_companies WHERE company_seq = #{company_seq}")
//    CompanyDto findAllById(int company_seq);
//
//    @Insert("INSERT into tb_companies(company_name,company_short_name,branch_id,adm_id,description) " +
//            "VALUES(#{company_name}, #{company_short_name},#{branch_id},#{adm_id},#{description})")
//    @ResultMap("com.staff.staffAttendance.mapper.CompanyMapper.companyResult")
//    void create(CompanyDto companyDto);
//
//    @Update("UPDATE tb_companies SET company_name=#{company_name}, company_short_name =#{company_short_name}, branch_id =#{branch_id},adm_id =#{adm_id}, description =#{description} WHERE company_seq =#{company_seq}")
//    @ResultMap("com.staff.staffAttendance.mapper.CompanyMapper.companyResult")
//    void update(CompanyDto companyDto);
//
//    @Delete("UPDATE tb_companies SET enabled=FALSE WHERE company_seq =#{company_seq}")
//    int delete(int company_seq);
//
//}
