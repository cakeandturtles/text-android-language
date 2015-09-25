import java.util.ArrayList;

import programComponents.TxtFunctionCall;
import programComponents.TxtStatement;
import programComponents.TxtStringValue;
import programComponents.TxtValue;

public class Program {
	String filename;
	ArrayList<TxtStatement> statements;
	
	public Program(String filename, String script){
		this.filename = filename;
		parse(script);
	}
	
	private void parse(String script){
		statements = new ArrayList<TxtStatement>();
		TxtTokenizer txt = new TxtTokenizer(script);
		
		while (!txt.isEndOfFile()){
			TxtStatement statement = parseStatement(txt);
			statements.add(statement);
			if (statement == null) break;
		}
	}
	
	private class Backtracker extends Throwable{}
	
	//TODO:: should return expression object
	private String parseExpression(TxtTokenizer txt){
		return "";
	}
	
	private TxtStatement parseStatement(TxtTokenizer txt){
		TxtStatement statement;
		Backtracker backtrack = new Backtracker();
		
		//function call
		txt.setBacktrackPoint();
		try{
			String whitespace = txt.getWhitespace();
			String funcName = txt.getIdentifier();
			if (funcName == null) throw backtrack;
			String newline = txt.getEndOfLine();
			if (newline != null){
				System.out.println("func call w/ no arguments: " + funcName);
				statement = new TxtFunctionCall(funcName);
				txt.clearBacktrack();
				return statement;
			}
			whitespace = txt.getWhitespace();
			if (whitespace == null) throw backtrack;
		
			ArrayList<TxtValue> arguments = new ArrayList<TxtValue>();
			
			//TODO:: need to look for any sort of expression/value
			String str = txt.getStringLiteral();
			if (str == null) throw backtrack;
			arguments.add(new TxtStringValue(str));
			
			System.out.println("func call: " + funcName + " w/ argument: " + str);
			statement = new TxtFunctionCall(funcName, arguments);
			
			//TODO:: allow for more than one parameter
			newline = txt.getEndOfLine();
			if (newline == null) throw backtrack;
			
			txt.clearBacktrack();
			return statement;
		}catch(Backtracker ex){
			txt.backtrack();
		}
		
		//variable assignment
		//function definition

		System.out.println("parse error");
		return null;
	}
}
