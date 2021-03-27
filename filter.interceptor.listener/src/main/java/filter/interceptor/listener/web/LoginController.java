package filter.interceptor.listener.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import filter.interceptor.listener.entity.User;
import filter.interceptor.listener.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping("login")
	@ResponseBody
	public String login(User user) {
		return loginService.login(user);
	}

	@RequestMapping("index")
	@ResponseBody
	public String index() {
		return loginService.index();
	}

	@RequestMapping("logout")
	@ResponseBody
	public String logout() {
		return loginService.logout();
	}

	@RequestMapping("online")
	@ResponseBody
	public Integer online() {
		return loginService.online();
	}

	@RequestMapping("denied")
	@ResponseBody
	public String denied() {
		return loginService.denied();
	}
}
