package filter.interceptor.listener.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import filter.interceptor.listener.component.MyListener;
import filter.interceptor.listener.constant.Constant;
import filter.interceptor.listener.entity.User;
import filter.interceptor.listener.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	HttpSession session;

	@Override
	public String login(User user) {
		if (session.getAttribute("userInfo") != null) {
			return Constant.L_I_S;
		}
		if (!Constant.users.containsKey(user.getUsername())) {
			return Constant.L_I_F;
		}
		if (!Constant.users.get(user.getUsername()).equals(user.getPassword())) {
			return Constant.L_I_F;
		}
		session.setAttribute("userInfo", user);

		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("User 【" + user.getUsername() + "】 had logged in on " + now);

		return Constant.L_I_S;
	}

	@Override
	public String logout() {
		session.invalidate();
		return Constant.L_O_S;
	}

	@Override
	public String index() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("You're ");
		stringBuffer.append(((User) session.getAttribute("userInfo")).toString());
		stringBuffer.append(". ");
		stringBuffer.append("This session will expire in " + session.getMaxInactiveInterval() + " seconds.");
		return stringBuffer.toString();
	}

	@Override
	public Integer online() {
		return MyListener.onlineUsers.get();
	}

	@Override
	public String denied() {
		return "DENIED";
	}

}
