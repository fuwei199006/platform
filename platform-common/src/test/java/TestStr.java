import org.junit.Test;
import org.omg.CORBA.portable.OutputStream;

import java.io.*;

public class TestStr {
	
	@Test
	public void stringToFile() throws Exception {
		String name = "Test";
		byte[] bytes = name.getBytes();
		FileOutputStream fileOutputStream = new FileOutputStream("D:/test.txt");
		fileOutputStream.write(bytes);
		fileOutputStream.close();
	}
	
	
	@Test
	public void fileToString() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:/test.txt");
		byte[] inByte = new byte[100];
		fileInputStream.read(inByte);
		String str = new String(inByte);
		System.out.println(str);
	}
	
	@Test
	public void stringToByte() throws Exception {
		String name = "fuwei";
		byte[] bytes = name.getBytes();
		for (byte b : bytes) {
			System.out.println(b);
		}
		
		String s = new String(bytes);
		System.out.println(s);
	}
	
	@Test
	public void streamTest() throws Exception {
		String str = "test";
		FileOutputStream fileOutputStream = new FileOutputStream("D:/Test.txt");
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
		writer.write(str.toCharArray());
		writer.close();
		
	}
	
	@Test
	public void streamReaderTest() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:/1.txt");
		InputStreamReader reader = new InputStreamReader(fileInputStream);
		FileReader fileReader = new FileReader("D:/1.txt");
		
	}
	
	@Test
	public void streamWriteTest() throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:/test.txt");
		InputStreamReader reader = new InputStreamReader(fileInputStream);
		char[] ch = new char[100];
		reader.read(ch);
		System.out.println(ch);
		
	}
}
