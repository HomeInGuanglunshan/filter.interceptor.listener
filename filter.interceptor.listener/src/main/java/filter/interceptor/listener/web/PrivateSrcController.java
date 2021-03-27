package filter.interceptor.listener.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrivateSrcController {

	@RequestMapping("privateSrc")
	@ResponseBody
	public String privateSrc() {
		return "privateSrc";
	}

}
