/**
 * 
 */
package com.lut.lwn.onlineexam.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * @author angw (mailTo:angw@primeton.com)
 * @since 2019年6月5日
 * @todo
 */
@Component
public class CompileUtils {
	@Test
	public void Test() {
		comm();
	}

	public String comm() {

		String[] cmds = { "/bin/sh" };
		String osType = System.getProperty("os.name");
		int result = 0;
		Process process;
		StringBuffer sb =new StringBuffer();
		StringBuffer resultSb;
		
		try {
			if (osType.startsWith("Windows")) {
				process = Runtime.getRuntime().exec("cmd");
			} else {
				process = Runtime.getRuntime().exec(cmds);
			}
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		Thread thread1 = new Thread("Excute") {
			public void run() {
				try {

					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
					
					bw.write("c:");
					bw.newLine();
					
					bw.write("cd " + "C:\\Users\\Administrator");
					bw.newLine();// 因为读取时是一行行读取的，不加newline无法继续往下读

					bw.write("g++ test1.cpp -o test1");
					bw.newLine();
					
					bw.write("test1.exe");
					bw.newLine();

					bw.flush();

					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

				}
			}
		};
		thread1.start();
		;
		Thread thread2 = new Thread("Read") {
			public void run() {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String cmdout = "";
					while ((cmdout = br.readLine()) != null) {
						sb.append(cmdout);
						
					}

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		};
		thread2.start();

		try {
			thread2.join();
		} catch (InterruptedException e) {
			result = 2;
			e.printStackTrace();
		}
		
		if(!new File("C:\\Users\\Administrator\\test1.exe").exists()) {
			System.out.println("编译不通过");
			return "编译不通过";
		}
		String substring = sb.substring(sb.toString().indexOf(".exe")+4);
		String substring2 = substring.substring(0, substring.length()-23);
		
		System.out.println(substring2);
		return substring2;

	}
}
