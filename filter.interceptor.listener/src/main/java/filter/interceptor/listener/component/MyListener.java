package filter.interceptor.listener.component;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import filter.interceptor.listener.entity.User;

public class MyListener implements HttpSessionListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static AtomicInteger onlineUsers = new AtomicInteger();

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		onlineUsers.getAndIncrement();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		User user = (User) httpSessionEvent.getSession().getAttribute("userInfo");
		logger.info("User 【" + user.getUsername() + "】 is out, need to log in again");
		onlineUsers.getAndDecrement();
	}

}
