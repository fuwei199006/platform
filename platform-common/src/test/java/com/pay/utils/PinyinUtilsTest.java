package com.pay.utils;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import static org.junit.Assert.*;

public class PinyinUtilsTest {
	
	@Test
	public void toPinYin() {
		try {
			System.out.println(new PinyinUtils().toPinYin("11中国通史第七卷-中古时代－五代辽宋夏金时期(上册).txt"));
		} catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
			badHanyuPinyinOutputFormatCombination.printStackTrace();
		}
	}
	
	@Test
	public void toPinYin1() {
	}
	
	@Test
	public void toPinYin2() {
	}
}