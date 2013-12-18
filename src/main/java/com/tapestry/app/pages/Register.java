package com.tapestry.app.pages;

import javax.security.sasl.AuthenticationException;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.tapestry.app.annotations.AnonymousAccess;
import com.tapestry.app.entities.User;
import com.tapestry.app.pages.crud.UserList;
import com.tapestry.app.pages.session.Signin;
import com.tapestry.app.services.Authenticator;
import com.tapestry.app.services.MisDAO;

@AnonymousAccess
public class Register {

	@Property
	@Validate("required")
	private String username;

	@Property
	@Validate("required")
	private String fullName;

	@Property
	@Validate("required,email")
	private String email;

	@Validate("required")
	private String password;

	@Validate("required")
	private String verifyPassword;


	@Inject
	private MisDAO crudServiceDAO;

	@Component
	private Form registerForm;

	@Inject
	private Messages messages;

	@Inject
	private Authenticator authenticator;

	@SuppressWarnings("unused")
	@InjectPage
	private Signin signin;
	//md5加密的函数
	/*public static String tomd5(String str) {
		StringBuffer hexString = new StringBuffer();
		if (str != null && str.trim().length() != 0) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
				byte[] hash = md.digest();
				for (int i = 0; i < hash.length; i++) {
					if ((0xff & hash[i]) < 0x10) {
						hexString.append("0"
								+ Integer.toHexString((0xFF & hash[i])));
					} else {
						hexString.append(Integer.toHexString(0xFF & hash[i]));
					}
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		}
		return hexString.toString();
	}*/

	@OnEvent(value = EventConstants.VALIDATE, component = "RegisterForm")
	public void checkForm() {
		if (!verifyPassword.equals(password)) {
			registerForm.recordError(messages.get("error.verifypassword"));
		}
	}

	@OnEvent(value = EventConstants.SUCCESS, component = "RegisterForm")
	public Object proceedSignup() {

		User userVerif = (User)crudServiceDAO.findWithQuery(username);

		if (userVerif != null) {
			registerForm.recordError(messages.get("error.userexists"));

			return null;
		}

		User user = new User();
		
		crudServiceDAO.create(user);

		try {
			authenticator.login(username, password);
		} catch (AuthenticationException ex) {
			registerForm.recordError("Authentication process has failed");
			return this;
		}

		return UserList.class;
	}

	public void setPassword(String password) {
		//执行md5加密
		//this.password = tomd5(password).toString();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setVerifyPassword(String verifyPassword) {

		//this.verifyPassword = tomd5(verifyPassword).toString();
		this.verifyPassword =verifyPassword;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}
}
