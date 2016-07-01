package net.hoyoung.user.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);

	@RequestMapping("/")
	public String index() {
		log.warn("fsdffffff------------------------------");
		return "user/index";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		return "add";
	}

	@RequestMapping("/del")
	@ResponseBody
	public String del() {
		return "del";
	}

	
	@RequestMapping("/edit")
	@ResponseBody
	public String jsonTest() {
		return "edit";
	}

}
