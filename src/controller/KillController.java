package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {super();}
	
	private String operationalSystem() {
		String idSystem = System.getProperty("os.name");	
		return idSystem; }
	
	private void callProcess (String callProcess) {
		
		String[] callProcessArray = callProcess.split(" ");

		try {
			
			Process process = Runtime.getRuntime().exec(callProcessArray); 
			InputStream returnn = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(returnn);
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
				while (line != null) {
					line = buffer.readLine();
					System.out.println(line);}
				
				buffer.close();
				reader.close();
				returnn.close();
				
			}catch(Exception e) {
				System.out.println(e.getMessage());}
	}
	
	public void listProcesses() {
		
		String typeOS = operationalSystem();
		
		if (typeOS.contains("Windows")){
			String callType = "TASKLIST /FO TABLE";
			callProcess(callType);}		
			
		if (typeOS.contains("Linux")){
			String callType = "ps -ef";
			callProcess(callType);}
				
	}
	
	
	public void killP(String pid) {
		
		String typeOS = operationalSystem();
		
		if (typeOS.contains("Windows")){
			String kill = "TASKKILL /PID " + pid;
			callProcess(kill);}		
			
		if (typeOS.contains("Linux")){
			String kill = "kill -9 " + pid;
			callProcess(kill);}
	}
	
	public void killN(String name) {
		
		String typeOS = operationalSystem();
		
		if (typeOS.contains("Windows")){
			String kill = "TASKKILL /IM " + name;
			callProcess(kill);}	
		
		if (typeOS.contains("Linux")){
			String kill = "pkill -f " + name;
			callProcess(kill);}
	}
}
