package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class SysAreaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 区域id
	 */
	private Long areaId;

	/**
	 * 区域代码
	 */
	private String areaCode;

	/**
	 * 父级代码，省级为0
	 */
	private String parentCode;

	/**
	 * 父级名称
	 */
	private String parentName;

	/**
	 * 区域名称
	 */
	private String name;

	/**
	 * 层级，1：省级，2：地市，3：区县
	 */
	private Integer layer;

	/**
	 * 排序
	 */
	private Integer orderNum;

	/**
	 * 状态，1：显示，0：隐藏
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private Timestamp gmtCreate;

	/**
	 * 修改时间
	 */
	private Timestamp gmtModified;

	/**
	 * ztree属性
	 */
	private Boolean open;

	private Boolean isParent;

	private Integer size;

	private List<?> list;


	public SysAreaEntity(String areaCode, String name) {
		this.areaCode = areaCode;
		this.name = name;
	}

}