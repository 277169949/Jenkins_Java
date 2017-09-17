package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileUtils {
	/**
	 * 
	 * @param filePathAndName  输入要创建的文件名称（包含路径和文件后缀）
	 * @param fileContent  要写入文件的内容
	 */
	public static void writeFile(String filePathAndName, String fileContent) {
		try {
			File f = new File(filePathAndName);
			if (!f.exists()) {
				f.createNewFile();
			}
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
			BufferedWriter writer = new BufferedWriter(write);

			writer.write(fileContent);
			writer.close();
			System.out.println(filePathAndName+"\\Create Succeed!");
		} catch (Exception e) {
			System.out.println("写文件内容操作出错");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param filePathAndName  文件名
	 * @return
	 */
	public static String readFile(String filePathAndName) {
		  String fileContent = "";
		  try {  
		   File f = new File(filePathAndName);
		   if(f.isFile()&&f.exists()){
		    InputStreamReader read = new InputStreamReader(new FileInputStream(f),"UTF-8");
		    BufferedReader reader=new BufferedReader(read);
		    String line;
		    while ((line = reader.readLine()) != null) {
		     fileContent += line;
		    }   
		    read.close();
		   }
		  } catch (Exception e) {
		   System.out.println("读取文件内容操作出错");
		   e.printStackTrace();
		  }
		  return fileContent;
		}
	
}
