package programComponents;

import java.util.ArrayList;

public class TxtFunctionCall extends TxtStatement{
	public String func_name;
	public ArrayList<TxtValue> arguments;
	
	public TxtFunctionCall(String func_name){
		this.func_name = func_name;
		this.arguments = new ArrayList<TxtValue>();
	}
	
	public TxtFunctionCall(String func_name, ArrayList<TxtValue> arguments){
		this.func_name = func_name;
		this.arguments = arguments;
	}
}
