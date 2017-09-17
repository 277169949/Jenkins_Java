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
	 * @param filePathAndName  ����Ҫ�������ļ����ƣ�����·�����ļ���׺��
	 * @param fileContent  Ҫд���ļ�������
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
			System.out.println("д�ļ����ݲ�������");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param filePathAndName  �ļ���
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
		   System.out.println("��ȡ�ļ����ݲ�������");
		   e.printStackTrace();
		  }
		  return fileContent;
		}
	
}
