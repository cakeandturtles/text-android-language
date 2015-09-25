import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import jdk.nashorn.internal.ir.FunctionCall;
import programComponents.TxtFunctionCall;
import programComponents.TxtStatement;

public class JavaTranslator{
	private Program program;
	
	public JavaTranslator(String filename, String program_text) throws IOException{
		
		program = new Program(filename, program_text);
	}
	
	public String ProgramToJavaCode(){
		String javaCode = "";
		
		//TODO: imports
		
		//file class initialization
		javaCode += "public class " + program.filename + "\n{\n";
		
		//main initialization
		javaCode += "\tpublic static void main(String[] args)\n\t{\n";
		
		//TODO: have some sort of programmatic indentation level
		for (int i = 0; i < program.statements.size(); i++){
			TxtStatement statement = program.statements.get(i);
			javaCode += "\t\t" + statementToJavaCode(statement);
		}
		
		//end of main
		javaCode += "\t}\n";
		
		//end of class
		javaCode += "}";
		
		return javaCode;
	}
	
	public String statementToJavaCode(TxtStatement statement){
		if (statement.getClass().equals(TxtFunctionCall.class)){
			return functionCallToJavaCode((TxtFunctionCall)statement);
		}
		return null;
	}
	
	public String functionCallToJavaCode(TxtFunctionCall call){
		String argumentString = "";
		String functionName = call.func_name;
		String defaultFunctionName = checkForDefaultFunctionName(call.func_name);
		if (defaultFunctionName != null)
			functionName = defaultFunctionName;
		
		for (int i = 0; i < call.arguments.size(); i++){
			if (i > 0) argumentString += ", ";
			argumentString += call.arguments.get(0).value;
		}
		return functionName + "(" + argumentString + ");\n";
	}
	
	public String checkForDefaultFunctionName(String functionName){
		if (functionName.equals("print"))
			return "System.out.println";
		return null;
	}
}