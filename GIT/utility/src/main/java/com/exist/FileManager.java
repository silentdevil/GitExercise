package com.exist.utility;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.util.List;
import java.net.URL;
import java.net.URLConnection;

public class FileManager {

	private File file;
	private InputStream input;
	private FileWriter writer;
	public FileManager(InputStream input, URL url) throws Exception{
		this.input = input;
		File file = FileUtils.toFile(url);
		try {
		writer = new FileWriter(file);
		
		} catch(Exception ex) {}

	}

	public FileManager(File file) {
		this.file = file;
	}
	
	public void setFile(String fileName) {
		file = new File(fileName);
	}
	List<String> stringLine;

	public File getFile() {
		return file;
	}

	public void writer (String text,boolean append) {
		try {
			if(input != null) {
				//IOUtils.write(text, writer);
				writer.write("HEEEY");
				return;
			}
			FileUtils.writeStringToFile(file,text,"UTF-8", append);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public List<String> reader() {
		
		try {
			stringLine = (input == null) ? FileUtils.readLines(file,"UTF-8") : IOUtils.readLines(input, "UTF-8");
		} catch(Exception ex) {
			writer("", false);
			reader();
		}

		return stringLine;
	}
	
}
