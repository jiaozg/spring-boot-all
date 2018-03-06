package com.example.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;// 主键.  
    private String name;// 名称.  

    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;// 资源类型，[menu|button]  
    private String url;// 资源路径.  
    private String permission; // 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view  
    private Long parentId; // 父编号  
    private String parentIds; // 父编号列表  
    private Boolean available = Boolean.FALSE;

//  @ManyToMany(fetch = FetchType.LAZY)  
//  @JoinTable(name = "SysRolePermission", joinColumns = { @JoinColumn(name = "permissionId") }, inverseJoinColumns = {  
//          @JoinColumn(name = "roleId") })  
//  private List<SysRole> roles;
}