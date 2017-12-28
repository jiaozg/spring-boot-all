package com.example.demo.mapper;

import com.example.demo.entity.SysArea;
import com.example.demo.form.AreaTree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface SysAreaMapper {


	@Select("SELECT * FROM sys_area")
	List<SysArea> getAll();

	@Select("SELECT * FROM sys_area WHERE area_id = #{id}")
    SysArea getOne(Long id);

	@Select("SELECT * FROM sys_area WHERE parent_code = #{pid}")
	List<SysArea> getByPid(Long pid);

	@Insert("INSERT INTO sys_area(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(SysArea area);

	@Update("UPDATE sys_area SET name=#{name} WHERE area_code =#{areaCode}")
	void updateName(SysArea area);

	@Delete("DELETE FROM sys_area WHERE id =#{id}")
	void delete(Long id);


	@Select("select area_code id, name, parent_code pId from sys_area")
	List<AreaTree> getAreaTree();

	@Select("select area_code id, name, parent_code pId from sys_area where parent_code = #{pid}")
	List<AreaTree> getAreaTreeByPid(Long pid);

}