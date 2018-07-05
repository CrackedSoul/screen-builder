package com.cs.screen.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.cs.screen.builder.item.Componment;

public class ComponentBuilder implements TemplateGenerator {
	private CompHtmlBuilder html;
	private CompTsBuilder ts;
	private String path;

	@Override
	public String generate() {
		return "";
	}
	public void generateFile(String name ,Componment comp) throws FileNotFoundException {
		File file=new File(path,name.toLowerCase());
		if(!file.exists())
			file.mkdirs();
		PrintWriter htmlWriter=new PrintWriter(getHtml(file,name));
		htmlWriter.println(html.gengratorPart(comp));
		htmlWriter.close();
		PrintWriter tsWriter=new PrintWriter(getTs(file,name));
		tsWriter.println(ts.gengratorPart(name, comp));
		tsWriter.close();
	}
	private File getHtml(File parent,String name) {
		File file=new File(parent,name.toLowerCase()+".componment.html");
		return file;
	}
	private File getTs(File parent,String name) {
		File file=new File(parent,name.toLowerCase()+".componment.ts");
		return file;
	}

	public CompPartBuilder getHtml() {
		return html;
	}

	public void setHtml(CompHtmlBuilder html) {
		this.html = html;
	}

	public CompPartBuilder getTs() {
		return ts;
	}

	public void setTs(CompTsBuilder ts) {
		this.ts = ts;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
