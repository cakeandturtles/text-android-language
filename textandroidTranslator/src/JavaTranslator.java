import java.io.File;
import java.util.Scanner;

public class JavaTranslator{
	private Program program;
	
	public JavaTranslator(String filename){
		//File
		String script = "print \"hello world\"\n"
				+ "		food     \n"
				+ "(";
		program = new Program(filename, script);
	}
}
