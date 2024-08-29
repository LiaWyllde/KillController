package view;

import controller.KillController;
import java.util.Scanner;


public class Main {
		
		public static void main(String[] args) {
			
			KillController kill = new KillController();
			Scanner scan = new Scanner(System.in);
			
			int option = 0;
			
			String menu = """
					
							Choose an option
							
							1 - Show processes
							2 - Kill process by PID
							3 - Kill process by name
							9 - Exit
							
					""";
			
			while (option != 9) {
				
				System.out.println(menu);
				option = scan.nextInt();
				
				switch (option) {
				
				case 1:
					kill.listProcesses();
					break;
				case 2:
					System.out.println("Insert process PID: ");
					String pid = scan.next();
					kill.killP(pid);
					break;
				case 3:
					System.out.println("Insert process name: ");
					String name = scan.next();
					kill.killN(name);
					break;
				case 9:
					System.out.println("Exiting...");
					break;
				} 
			}
			scan.close();
		}
	}



