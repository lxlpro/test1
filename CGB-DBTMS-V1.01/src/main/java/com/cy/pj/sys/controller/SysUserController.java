package com.cy.pj.sys.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;

@RestController
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	@Qualifier("sysUserServiceImpl")
	private SysUserService sysUserService;
	
	@GetMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysUserService.findObjectById(id));
	}
	@RequestMapping("doValidById")
	public JsonResult doValidById(
			Integer id,Integer valid) {
		sysUserService.validById(id, valid,
				"admin");
		return new JsonResult("update ok");
	}
	@PostMapping("doUpdateObject")
	public JsonResult doUpdateObject(
			SysUser entity,Integer[] roleIds) {
		sysUserService.updateObject(entity, roleIds);
		return new JsonResult("update ok");
	}
	@PostMapping("doSaveObject")
	public JsonResult doSaveObject(
			@Valid SysUser entity,Integer[] roleIds) {
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult("save ok");
	}
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String username,
			Integer pageCurrent) {
		return new JsonResult(
		     sysUserService.findPageObjects(username,
				pageCurrent));
	}
	
}
