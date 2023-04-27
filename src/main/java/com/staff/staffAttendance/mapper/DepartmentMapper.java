package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.DepartmentDto;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface DepartmentMapper {

//    @Select("SELECT * from tb_depart WHERE enabled = TRUE")
//    @ResultMap("com.staff.staffAttendance.mapper.DepartmentMapper.departResult")
//    List<DepartmentDto> findAll();

        @Select("SELECT tc.departSeq,tc.name,tc.short_name,tc.description,tc.enabled\n" +
            ",(SELECT br.name FROM tb_branches br WHERE br.brSeq = tc.brId) AS brId \n" +
            "FROM tb_depart tc WHERE tc.enabled = TRUE;")
    List<Map<String,Object>> findAll();

    @Select("SELECT tc.brId AS branchId, (SELECT br.name FROM tb_branches br WHERE br.brSeq = tc.brId) AS branchName FROM tb_depart tc WHERE tc.departSeq = #{departSeq}")
//    @ResultMap("com.staff.staffAttendance.mapper.CompanyMapper.companyResult")
    Map<String, Object> findBranchNameByDepartId(int departSeq);

    @Select("SELECT name from tb_depart WHERE name = #{name}")
    String findByBranchName(String name);

    @Select("SELECT departSeq from tb_depart WHERE departSeq = #{departSeq}")
    DepartmentDto findById(int departSeq);

    @Select("SELECT * from tb_depart WHERE departSeq = #{departSeq}")
    DepartmentDto findAllById(int departSeq);

    @Insert("INSERT into tb_depart(name,short_name,brId,description) VALUES(#{name}, #{short_name}, #{brId},#{description})")
    @ResultMap("com.staff.staffAttendance.mapper.DepartmentMapper.departResult")
    void create(DepartmentDto departmentDto);

    @Update("UPDATE tb_depart SET name=#{name}, short_name =#{short_name},brId =#{brId}, description =#{description} WHERE departSeq =#{departSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.DepartmentMapper.departResult")
    void update(DepartmentDto departmentDto);

    @Delete("UPDATE tb_depart SET enabled=FALSE WHERE departSeq =#{departSeq}")
    int delete(int departSeq);
}
