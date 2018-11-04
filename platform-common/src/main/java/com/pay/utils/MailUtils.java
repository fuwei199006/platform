package com.pay.utils;

import org.springframework.util.StringUtils;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;


public class MailUtils {
	
	public static void sendMail(Properties prop, String recivers, String cc, String title, String content, byte[] attachMent, boolean isHtml) {
		
		//使用java发送邮件5步骤
		//1.创建sesssion
		Session session = Session.getInstance(prop);
		try {
			//2.通过session获取Transport对象（发送邮件的核心API）
			 Transport ts = session.getTransport();
			//3.通过邮件用户名密码链接
			ts.connect("smtp.163.com", "taohuihui_yh@163.com", "Abc12345");
			//4.创建邮件
			MimeMessage mm = new MimeMessage(session);
			//设置发件人
			mm.setFrom(new InternetAddress("taohuihui_yh@163.com"));
			Address[] address = new InternetAddress().parse(recivers);
			mm.setRecipients(Message.RecipientType.TO, address);
			
			//设置抄送人
			if (!StringUtils.isEmpty(cc)) {
				mm.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			}
			
			
			mm.setSubject(title);
			if (isHtml) {
				mm.setContent(content, "text/html;charset=utf-8");
			} else {
				mm.setText(content);
			}
			
			//5.发送电子邮件
			ts.sendMessage(mm, mm.getAllRecipients());
		} catch (Exception ex) {
			//log
			ex.printStackTrace();
		}
	}
	
	public static void sendMail(String recivers, String title, String content) {
		Properties prop = new Properties();
		prop.put("mail.host", "smtp.163.com");
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", true);
		sendMail(prop, recivers, "", title, content, null, true);
	}
	
	public static void sendQQMail(String recivers, String title, String content) {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.qq.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.smtp.port", "465");
		prop.setProperty("mail.smtp.socketFactory.port", "465");
		Session session = Session.getInstance(prop);
		try {
			//2.通过session获取Transport对象（发送邮件的核心API）
			Transport ts = session.getTransport();
			//3.通过邮件用户名密码链接
			ts.connect("smtp.qq.com", "taohh_yh@qq.com", "qjkwjxwkdiagjfdc");
			//4.创建邮件
			MimeMessage mm = new MimeMessage(session);
			//设置发件人
			mm.setFrom(new InternetAddress("taohh_yh@qq.com"));
			Address[] address = new InternetAddress().parse(recivers);
			mm.setRecipients(Message.RecipientType.TO, address);
			mm.setSubject(title);
			mm.setContent(content, "text/html;charset=utf-8");
			//5.发送电子邮件
			ts.sendMessage(mm, mm.getAllRecipients());
		} catch (Exception ex) {
			//log
			ex.printStackTrace();
		}
	}
	
}
