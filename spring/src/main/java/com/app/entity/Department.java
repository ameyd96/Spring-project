package com.app.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Please Add Department Name ")
	private String deptName;
	private String deptAddress;
	private String deptCode;
	
	
//	public Department() {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Department(Long id, String deptName, String deptAddress, String deptCode) {
//		super();
//		this.id = id;
//		this.deptName = deptName;
//		this.deptAddress = deptAddress;
//		this.deptCode = deptCode;
//	}
//
//
//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//
//	public String getDeptName() {
//		return deptName;
//	}
//
//
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}
//
//
//	public String getDeptAddress() {
//		return deptAddress;
//	}
//
//
//	public void setDeptAddress(String deptAddress) {
//		this.deptAddress = deptAddress;
//	}
//
//
//	public String getDeptCode() {
//		return deptCode;
//	}
//
//
//	public void setDeptCode(String deptCode) {
//		this.deptCode = deptCode;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Department [id=" + id + ", deptName=" + deptName + ", deptAddress=" + deptAddress + ", deptCode="
//				+ deptCode + "]";
//	}
//	
	
}
