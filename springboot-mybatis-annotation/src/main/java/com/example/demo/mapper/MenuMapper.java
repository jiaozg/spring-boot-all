package com.example.demo.mapper;

import com.example.demo.entity.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

	List<Menu> selectMenuByRoleid(@Param("roleid") Integer roleid);

    @Select("SELECT * FROM menu")
	List<Menu> selectAll();

    @Select("SELECT * FROM menu where parentid = #{pid}")
    List<Menu> selectByParentid(Integer pid);

    @Delete("DELETE FROM menu WHERE id =#{id}")
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM menu where username = #{username}")
    Menu selectByName(String username);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);


}