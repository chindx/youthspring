package com.chindx.youth.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.chindx.youth.entity.User;
import com.chindx.youth.service.UserService;

@Controller
@RequestMapping(value= "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getuserList(ModelMap map) {
		map.addAttribute("userList", userService.findAll());
		return "user/userList";
	}
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createuserForm(ModelMap map) {
		map.addAttribute("user", new User());
		map.addAttribute("action", "create");
		return "user/userForm";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String postuser(ModelMap map, @ModelAttribute @Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			map.addAttribute("action", "create");
			return "user/userForm";
		}
		userService.insertByUser(user);
		return "redirect:/users/";
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
	public String getuser(@PathVariable Long id, ModelMap map) {
		map.addAttribute("user", userService.getUser(id));
		map.addAttribute("action", "update");
		return "user/userForm";
	}
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String putuser(ModelMap map, @ModelAttribute @Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			map.addAttribute("action", "update");
			return "user/userForm";
		}
		userService.update(user);
		return "redirect:/users/";
	}
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteuser(@PathVariable Long id) {
		userService.delete(id);
		return "redirect:/users/";
	}
	/**
	 * 获取用户分页列表
	 * 	处理"/users"的GET请求，用来获取用户分页列表
	 * 	通过@RequestParam 传递参数，进行进一步条件查询或者分页查询
	 * 	Pageable 支持的分页参数如下
	 * 	page - 当前页从0 开始
	 * 	size - 每页显示默认值在application.properties配置
	 * */
	@RequestMapping(value="/pages", method= RequestMethod.GET)
	public String getUserPage(ModelMap map, Pageable pageable) {		
		Page<User> page = (Page<User>)userService.findByPage(pageable);
		map.addAttribute("page", page);
		System.err.println(page);		
		return "user/userPage";
	}		
}
