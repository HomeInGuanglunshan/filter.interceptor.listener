package filter.interceptor.listener.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublicSrcController {

	@RequestMapping("publicSrc")
	@ResponseBody
	public String publicSrc() {
		return "publicSrc";
	}
}
