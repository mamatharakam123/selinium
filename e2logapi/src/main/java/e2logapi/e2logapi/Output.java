package e2logapi.e2logapi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Output {
	public static void OutputConsole(String console) throws Exception{
		File file = new File(Utils.fileNameForOutput());
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(console);
		bw.newLine();
		bw.close();
	}

	public static void OutputConsoleForDatabase(String Errors) throws Exception {
		File file = new File(Utils.fileNameForDatabaseOutput());
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Errors);
		bw.newLine();
		bw.close();
	}
	public static void main(String[] args) {
		
	}

}
