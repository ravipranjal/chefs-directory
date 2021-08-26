package com.springboot.chefs.demo1.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.chefs.demo1.dao.ChefsInfoDao;
import com.springboot.chefs.demo1.dao.DishInfoDao;
import com.springboot.chefs.demo1.models.ChefDish;
import com.springboot.chefs.demo1.models.ChefsInfo;
import com.springboot.chefs.demo1.models.DishInfo;


@Controller
public class DishController {
	@Autowired ChefsInfoDao chefdao;
	@Autowired DishInfoDao dishdao;
	
	@RequestMapping("/listdishesforchef")
	public String listDishes(Model model) {
		List<DishInfo> alldishes = dishdao.GetAllDishes();
		model.addAttribute("alldishes",alldishes);
		return "ListDishes.jsp";
	}
	
	@RequestMapping("/listchefsfordish")
	public String listChefForDish(HttpServletRequest request, Model model) {
		String dishname = request.getParameter("dishname");
		if(dishname.equals("-- Select --")) return "/listdishesforchef";
		List<ChefDish> chefsfordish = dishdao.GetChefFromDish(dishname);
		model.addAttribute("chefsfordish",chefsfordish);
		model.addAttribute("dishname",dishname);
		return "ViewChefsForDish.jsp";
	}
	
	@RequestMapping("/listchefsfordishes")
	public String ListChefsForDishes(Model model) {
		List<ChefsInfo> allchefs = chefdao.GetAllChefs();
		model.addAttribute("allchefs",allchefs);
		return "ViewChefsForDishes.jsp";
	}
	
	@RequestMapping("/viewdishes")
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
		chefname =  chefname.substring(0, chefname.indexOf(" ")); 
		List<DishInfo> dishes = dishdao.QueryDishesForChef(id);
		model.addAttribute("dishes",dishes);
		model.addAttribute("chefname",chefname);
		return "ViewDishesForChef.jsp";
	}
	
}
