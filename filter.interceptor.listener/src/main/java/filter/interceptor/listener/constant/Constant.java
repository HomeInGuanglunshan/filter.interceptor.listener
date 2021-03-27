package filter.interceptor.listener.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {

	/** Login successfully! **/
	public static String L_I_S = "Login successfully!";
	/** Login failed! **/
	public static String L_I_F = "Login failed!";
	/** Logout successfully! **/
	public static String L_O_S = "Logout successfully!";

	public static Map<String, String> users = new HashMap<String, String>();
	static {
		users.put("lida", "111111");
		users.put("finest", "123456");
	}
}
