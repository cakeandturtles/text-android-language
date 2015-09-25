import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args){
		String path = "assets/";
		String filename = "hello";
		String extension = ".txt";
	
		try {
			int len;
			final FileReader reader = new FileReader(path + filename + extension);
			final StringBuffer buffer = new StringBuffer();
			char[] chr = new char[4096];
			
			try{
				while((len = reader.read(chr)) > 0){
					buffer.append(chr, 0, len);
				}
			}finally{
				reader.close();
			}
			
			String program_text = buffer.toString();
			
			JavaTranslator translator = new JavaTranslator(filename, program_text);
			String javaCode = translator.ProgramToJavaCode();
			System.out.println(javaCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
