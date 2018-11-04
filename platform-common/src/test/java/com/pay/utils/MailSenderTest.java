package com.pay.utils;

import com.pay.utils.enums.MailType;
import org.junit.Test;

import javax.mail.MessagingException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MailSenderTest {
	
	@Test
	public void sender() {
		try {
			MailSender sender = new MailSender(MailType.m163, "laofu_online@163.com", "Abc12345");
			sender.sender("756091180@qq.com", "test", "test");
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sender1() {
		try {
			
			MailSender sender = new MailSender(MailType.m163, "laofu_online@163.com", "Abc12345");
			sender.sender("756091180@qq.com", "唐诗宋词", "唐诗宋词鉴赏",getFileMap());
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	Map<String,byte[]> getFileMap(){
		Map<String,byte[]> attachments=new HashMap<>();
		byte[] bytes="唐玄宗当政时期的唐王朝，在当时的世界上是一个大国。但就在这表面上看起来仍然强大的大国里，因上下其手等诸多原因，业已孳生着崩溃的征兆。终于唐王朝迅速走向倾覆的转折点——“安史之乱”的发生。杜甫获悉这种情况后，觉得当权者不顾民生只顾自己享乐的做法，定然会导致国家的败亡；于是他便大为愤慨地挥笔写下后来被选进著名选本《唐诗三百首》的诗作，亦即题为《丽人行》的七言长篇古诗。该诗由于把杨家那炙手可热的奢侈生活作了大胆的讽刺和深刻的揭露，成为一首名副其实的“史诗”；而人们还从中概括出一个成语“炙手可热”，用来表明气焰很盛，权势很大的那一号货色。".getBytes();
		byte[] bytes2="唐玄宗当政时期的唐王朝，在当时的世界上是一个大国。但就在这表面上看起来仍然强大的大国里，因上下其手等诸多原因，业已孳生着崩溃的征兆。终于唐王朝迅速走向倾覆的转折点——“安史之乱”的发生。杜甫获悉这种情况后，觉得当权者不顾民生只顾自己享乐的做法，定然会导致国家的败亡；于是他便大为愤慨地挥笔写下后来被选进著名选本《唐诗三百首》的诗作，亦即题为《丽人行》的七言长篇古诗。该诗由于把杨家那炙手可热的奢侈生活作了大胆的讽刺和深刻的揭露，成为一首名副其实的“史诗”；而人们还从中概括出一个成语“炙手可热”，用来表明气焰很盛，权势很大的那一号货色。".getBytes();
		attachments.put("poem1.txt",bytes);
		attachments.put("poem2.txt",bytes2);
		return attachments;
	}
	
	@Test
	public void sender2() {
	}
	
	@Test
	public void sender3() {
	}
}