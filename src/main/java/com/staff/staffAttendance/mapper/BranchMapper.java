package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.BranchDto;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BranchMapper {

//    @Results({
//        @Result(property = "branch_seq", column = "branch_seq"),
//        @Result(property = "name", column = "name"),
//        @Result(property = "address", column = "address"),
//        @Result(property = "description", column = "description"),
//        @Result(property = "status", column = "status")
//    })

    @Select("SELECT * from tb_branches WHERE enabled = TRUE")
    @ResultMap("com.staff.staffAttendance.mapper.BranchMapper.branchResult")
    List<BranchDto> findAll();

    @Select("SELECT name from tb_branches WHERE name = #{name}")
    String findByBranchName(String name);

    @Select("SELECT brSeq from tb_branches WHERE brSeq = #{brSeq}")
    BranchDto findById(int brSeq);

    @Select("SELECT * from tb_branches WHERE brSeq = #{brSeq}")
    BranchDto findAllById(int brSeq);

    @Insert("INSERT into tb_branches(name,address,description) VALUES(#{name}, #{address},#{description})")
    @ResultMap("com.staff.staffAttendance.mapper.BranchMapper.branchResult")
    void create(BranchDto branchDto);

    @Update("UPDATE tb_branches SET name=#{name}, address =#{address}, description =#{description} WHERE brSeq =#{brSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.BranchMapper.branchResult")
    void update(BranchDto branchDto);

    @Delete("UPDATE tb_branches SET enabled=FALSE WHERE brSeq =#{brSeq}")
    int delete(int brSeq);

}
