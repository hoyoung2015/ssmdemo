package cn.hoyoung.web.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.hoyoung.entity.User;
@Controller
@RequestMapping("/user")
public class UserCtrl {
	private Logger log = Logger.getLogger(UserCtrl.class);
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
		List<User> list = new ArrayList<User>();
		list.add(new User("hoyoung", 24));
		list.add(new User("xiaoniu", 22));
		return new ModelAndView("user/show","users",list);
	}
	@ResponseBody
	@RequestMapping("/info.json")
	public Map<String,String> jsonTest(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "hoyoung");
		return map;
	}
	
}
