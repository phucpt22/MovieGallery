package com.poly.service.impl;

import javax.servlet.ServletContext;

import com.poly.entity.User;
import com.poly.service.EmailService;
import com.poly.utils.SendEmailUtil;

public class EmailServiceImpl implements EmailService {
	private static final String EMAIL_WELCOME_SUBJECT = "Welcome to SHOW_VIDEO_PTP Entertainment";
	private static final String EMAIL_FORGOT_SUBJECT = "Send new Password from SHOW_VIDEO_PTP Entertainment";	
	@Override
	public void sendMail(ServletContext context, User recipient, String type) {
        String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        try {
			String content = null;
			String subject = null;
			switch(type) {
				case "welcome":
					subject = EMAIL_WELCOME_SUBJECT;
					content = "DEAR "+recipient.getUsername()+", Hope you guys enjoy the movie!!";
					break;
				case "forgot":
					subject = EMAIL_FORGOT_SUBJECT;
					content = "DEAR "+recipient.getUsername()+", your new password here: "+recipient.getPassword();
					break;
				default:
					subject = "SHOW_VIDEO_PTP";
					content = "ERROR! Please try again!";
					break;
			}
			SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
