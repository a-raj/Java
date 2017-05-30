package learn.langPackage;

public class OpenNotepad {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		
		try {
			process = runtime.exec("notepad");
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
