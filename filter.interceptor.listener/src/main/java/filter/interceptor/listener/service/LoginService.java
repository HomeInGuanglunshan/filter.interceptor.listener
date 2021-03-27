package filter.interceptor.listener.service;

import filter.interceptor.listener.entity.User;

public interface LoginService {

	String login(User user);

	String logout();

	String index();

	Integer online();

	String denied();

}
