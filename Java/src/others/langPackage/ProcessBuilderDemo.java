package others.langPackage;

import java.io.IOException;

public class ProcessBuilderDemo {
	
	public static void main(String[] args) {
		
		try {
			ProcessBuilder process = new ProcessBuilder("notepad.exe","testfile");
			process.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
