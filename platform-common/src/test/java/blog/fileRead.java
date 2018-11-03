package blog;

import com.pay.utils.PinyinUtils;
import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class fileRead {
	@Test
	public void readFile() {
		
		File file = new File("E:\\WorkSpace\\Movie\\_layouts\\ctwp.txt");
		List<String> stringList = new ArrayList<>();
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
				stringList.add(s);
			}
			br.close();
			
			PinyinUtils pinyinUtils = new PinyinUtils();
			String temp = readTxt("E:\\WorkSpace\\Movie\\_layouts\\template.txt");
			System.out.println(temp);
			int i = 0;
			for (String item : stringList) {
				
				String[] itemArr = item.split(":");
				String title = itemArr[0].replace(" ","-").replace("《","-").replace("》","").replace("[","").replace("]","");
				String url = itemArr[1]+":"+itemArr[2];
				String date = LocalDate.parse("2018-07-01").plusDays(i++ / 10).toString();
				String content = temp.replace("{{title}}", title).replace("{{date}}", date).replace("{{url}}", url);
				
				String writeName="E:\\WorkSpace\\Movie\\_posts\\"+date+"-Post" +pinyinUtils.toPinYin(title) ;
				File writefile = new File(writeName+".md");
				if(writefile.exists()){
					writeName+="_1";
				}
				FileWriter writer = new FileWriter(writeName+".md");
				writer.write(content);
				writer.close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String readTxt(String filePath) {
		try {
			File file = new File(filePath);
			
			StringBuilder stringBuilder = new StringBuilder();
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String s = null;
			while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
				stringBuilder.append(s + LineSeparator.Windows);
			}
			br.close();
			return stringBuilder.toString();
		} catch (Exception e) {
			return "";
		}
	}
	
}
