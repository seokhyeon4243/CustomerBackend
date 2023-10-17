package myspring.customuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.customuser.service.CustomUserService;
import myspring.customuser.vo.CustomUserVO;

@Controller
public class CustomUserController {
	@Autowired
	private CustomUserService customUserService;
	
	public CustomUserController() {
		System.out.println(this.getClass().getName() + "생성자 호출");
	}
	@RequestMapping("/customUserList.do")
	public ModelAndView customUserList() {
		List<CustomUserVO> customUserVOList = customUserService.getCustomUserList();
		return new ModelAndView("customUserList", "customUserList", customUserVOList);
	}
	@RequestMapping("/getCustomUser.do")
	public String getCustomUser(@RequestParam("id") int id, Model model) {
		CustomUserVO customUserVO = customUserService.getCustomUser(id);
		model.addAttribute("customuser", customUserVO);
		return "customUserInfo";
	}
}
