package filter.interceptor.listener.component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import filter.interceptor.listener.entity.User;

public class MyFilter implements Filter {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("My filter had been initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpServletRequest.getSession(false);
		if (httpSession == null) {
			chain.doFilter(request, response);
			return;
		}

		User user = (User) httpSession.getAttribute("userInfo");
		if (httpServletRequest.getRequestURI().indexOf("/privateSrc") != -1 && user != null
				&& !"lida".equals(user.getUsername())) {
//			简单写法的HttpClient，接收不到redirect之后的输出
//			HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
//			wrapper.sendRedirect("/denied");

			RequestDispatcher requestDispatcher = ((HttpServletRequest) request).getRequestDispatcher("/denied");
			requestDispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
