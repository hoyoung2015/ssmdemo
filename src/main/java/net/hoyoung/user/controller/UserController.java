package net.hoyoung.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.hoyoung.user.vo.User;
@Controller
@RequestMapping("/user")
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	@RequestMapping("/")
	public String index(){
		log.warn("fsdffffff------------------------------");
		return "user/index";
	}
	@RequestMapping("/add")
	public String add(){
		log.warn("add------------------------------");
		return "user/index";
	}
	@RequestMapping("/show")
	public ModelAndView show(){
		log.warn("show------------------------------");
		ModelMap mm = new ModelMap();
		mm.put("users", new ArrayList<User>());
		
		return new ModelAndView("user/show",mm);
	}
	@ResponseBody
	@RequestMapping("/info.json")
	public Map<String,String> jsonTest(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "hoyoung");
		return map;
	}
	
}
