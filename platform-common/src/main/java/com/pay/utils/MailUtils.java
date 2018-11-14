package com.pay.utils;

import com.pay.utils.enums.MailType;
import org.springframework.util.StringUtils;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class MailUtils {
	
	private MailSender mailSender;
	private MailReciver mailReciver;
	private MailType mailType;
	
	MailUtils(MailType mailType, String userName, String passWord) {
		this.mailType = mailType;
		mailSender = new MailSender(mailType, userName, passWord);
		mailReciver = new MailReciver(mailType, userName, passWord);
	}
	
	public boolean sender(String recivers, String cc, String mailTitle, String mailContent, boolean isHtml) throws MessagingException, IOException {
		return mailSender.sender(recivers, cc, mailTitle, mailContent, isHtml, null);
	}
	
	public boolean sender(String recivers, String cc, String mailTitle, String mailContent) throws MessagingException, IOException {
		return mailSender.sender(recivers, cc, mailTitle, mailContent, true, null);
	}
	
	public boolean sender(String recivers, String mailTitle, String mailContent) throws MessagingException, IOException {
		return mailSender.sender(recivers, null, mailTitle, mailContent, true, null);
	}
	
	public boolean sender(String recivers, String mailTitle, String mailContent, Map<String, byte[]> mapFile) throws MessagingException, IOException {
		return mailSender.sender(recivers, null, mailTitle, mailContent, true, mapFile);
	}
	public Message[] getMails() throws MessagingException {
		return mailReciver.getMails();
	}
	
}
