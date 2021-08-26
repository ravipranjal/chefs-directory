package com.springboot.chefs.demo1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.chefs.demo1.dao.ChefsInfoDao;
import com.springboot.chefs.demo1.dao.DishInfoDao;
import com.springboot.chefs.demo1.models.ChefsInfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChefsController {
	
	@Autowired ChefsInfoDao chefdao;
	@Autowired DishInfoDao dishdao;
		
	@GetMapping("/create")
	public String Create() {
		return "Create.jsp";
	}
	
	@RequestMapping("/createDB")
	public String CreateDB(HttpServletRequest request, Model model) {
		ChefsInfo cc = new ChefsInfo();
		cc.cname = request.getParameter("chefname");
		cc.address = request.getParameter("address");
		cc.phone = request.getParameter("phone");
		boolean success = chefdao.CreateChef(cc);
		model.addAttribute("back", "/create");
		if(success) return "success.jsp";
		else return "failed.jsp";
	}
	
	@RequestMapping("/delete")
	public String Delete(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		model.addAttribute("selected",allchefs.get(0));		
		return "Delete.jsp";
	}
	
	@RequestMapping("/viewdetails")
	public String ViewDetails(HttpServletRequest request, Model model) {
		String chefname = request.getParameter("chefname");
		if(chefname.equals("-- Select --")) return "/delete";
		int len = chefname.length();
		int id=0,mul=1;
		for(int i=len-1;i>=0;i--) {
			char c = chefname.charAt(i);
			if(c-'0'<0 || c-'0'>9) break;
			id = mul*(c-'0')+id;
			mul = mul*10;
		}
		ChefsInfo ci = chefdao.QueryOneChef(id);
		model.addAttribute("chef",ci);
		return "ViewDetailsDelete.jsp";
	}
	
	
	@RequestMapping("/deleteDB")
	public String DeleteDB(HttpServletRequest request,Model model) {
		int id = Integer.valueOf(request.getParameter("id"));
		boolean success = chefdao.DeleteChef(id);
		model.addAttribute("back", "/delete");
		if(success) return "success.jsp";
		else return "failed.jsp";
	}
	
	@RequestMapping("/update")
	public String Update(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		model.addAttribute("selected",allchefs.get(0));
		return "Update.jsp";
	}
	
	@RequestMapping("/updateforonechef")
	public String UpdateForOne(HttpServletRequest request, Model model) {
		String chefname = request.getParameter("chefname");
		if(chefname.equals("-- Select --")) return "/update";
		int len = chefname.length();
		int id=0,mul=1;
		for(int i=len-1;i>=0;i--) {
			char c = chefname.charAt(i);
			if(c-'0'<0 || c-'0'>9) break;
			id = mul*(c-'0')+id;
			mul = mul*10;
		}
		ChefsInfo ci = chefdao.QueryOneChef(id);
		model.addAttribute("chef",ci);
		return "UpdateOneChef.jsp";
	}
	
	@RequestMapping("/updateDB")
	public String UpdateDB(HttpServletRequest request, Model model) {
		ChefsInfo cc = new ChefsInfo();
		cc.id = Integer.valueOf(request.getParameter("id"));
		cc.cname = request.getParameter("chefname");
		cc.address = request.getParameter("address");
		cc.phone = request.getParameter("phone");
		model.addAttribute("back", "/update");
		boolean success = chefdao.UpdateChef(cc);
		if(success) return "success.jsp";
		else return "failed.jsp";
	}
	
	@RequestMapping("/cheffromaddress")
	public String QueryNameFromAddress(@RequestBody ChefsInfo ci) {
		return chefdao.QueryChefFromAddress(ci);
	}

	@RequestMapping("/allchefs")
	public String GetAll(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "ViewAll.jsp";
	}
	
	@RequestMapping("/getcheffromaddress")
	public String ListChefsForDishes(Model model) {
		List<ChefsInfo> allchefs =  chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "ChefFromAddress.jsp";
	}
	
	
	@RequestMapping("/viewchefforaddress")
	public String ListChefsForDishes(HttpServletRequest request, Model model) {
		String address = request.getParameter("address");
		ChefsInfo ci =  chefdao.GetChefFromAddress(address);
		model.addAttribute("chef",ci.cname);
		model.addAttribute("address",address);
		return "ChefForAnAddress.jsp";
	}
	
}
