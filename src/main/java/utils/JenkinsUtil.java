package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

/**
 * @author lieber
 *
 */

public class JenkinsUtil {
	static String url = "http://127.0.0.1:8080/jenkins/";
	static JenkinsServer server;
	static StringBuilder build = new StringBuilder();
	static String name = "lieber";
	static String password = "123456";
	static {
		try {

			server = new JenkinsServer(new URI(url), name, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createView(String viewName) throws IOException {
		String viewXml = FileUtils.readFile("Template\\View\\viewtemplate.xml");
		System.out.println(viewXml);
		server.createView(viewName, viewXml);

	}



	public static void main(String[] args) throws IOException {
		createView("222") ;
	}

	/**
	 * 
	 * @throws IOException
	 *             获取template 试图下的所有job的config.xml文件
	 */
	public static void getAllTemplateConfigxmlFile() throws IOException {
		String filepath = "Template\\Job1";
		List<Job> jobLists = getJobsByView("template");
		for (Job job : jobLists) {
			FileUtils.writeFile(filepath + job.getName() + ".xml", server.getJobXml(job.getName()));
		}
	}
	
	
	/**
	 * 
	 * @param viewName  视图名字
	 * @return  返回试图下的所有job
	 * @throws IOException
	 */
	public static List<Job> getJobsByView(String viewName) throws IOException {
		Map<String, Job> map = server.getJobs(viewName);
		List<Job> jobLists = new ArrayList<Job>(map.values());
		return jobLists;
	}

}
