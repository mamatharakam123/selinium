package com.workfall.api.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
