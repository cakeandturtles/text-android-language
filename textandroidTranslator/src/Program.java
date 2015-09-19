import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
	String filename;
	
	public Program(String filename, String script){
		this.filename = filename;
		parse(script);
	}
	
	private void parse(String script){
		TxtTokenizer txt = new TxtTokenizer(script);
		
		Pattern pattern = Pattern.compile("^.");
		while (!txt.isEndOfFile()){
			String statement = parseStatement(txt);
			if (statement == null) break;
		}
	}
	
	private class Backtracker extends Throwable{}
	
	//TODO:: should return expression object
	private String parseExpression(TxtTokenizer txt){
		return "";
	}
	
	//TODO:: should return statement object
	private String parseStatement(TxtTokenizer txt){
		Backtracker backtrack = new Backtracker();
		
		//function call
		txt.setBacktrackPoint();
		try{
			String whitespace = txt.getWhitespace();
			String id = txt.getIdentifier();
			if (id == null) throw backtrack;
			String newline = txt.getEndOfLine();
			if (newline != null){
				System.out.println("func call w/ no arguments: " + id);
				//TODO: make statement object with appropriate properties
				txt.clearBacktrack();
				return "";
			}
			whitespace = txt.getWhitespace();
			if (whitespace == null) throw backtrack;
		
			//TODO:: need to look for any sort of expression/value
			String str = txt.getStringLiteral();
			if (str == null) throw backtrack;
			
			System.out.println("func call: " + id + " w/ argument: " + str);
			
			//TODO:: allow for more than one parameter
			newline = txt.getEndOfLine();
			if (newline == null) throw backtrack;
			
			txt.clearBacktrack();
			return "";
		}catch(Backtracker ex){
			txt.backtrack();
		}
		
		//variable name
		//function definition

		System.out.println("parse error");
		return null;
	}
}
