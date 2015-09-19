import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtTokenizer {
	private Stack<Integer> backtrackPoints;
	private int position;
	private int line;
	private int column;
	private String source;
	
	Pattern alphaPattern;
	Pattern integerPattern;
	Pattern emojiPattern;
	Pattern idPattern;
	Pattern numberPattern;
	Pattern stringPattern;
	Pattern whitespacePattern;
	Pattern endOfLinePattern;
	
	public TxtTokenizer(String source){
		this.source = source;
		
		backtrackPoints = new Stack<Integer>();

		//construct patterns
		alphaPattern = Pattern.compile("^[\\pL\\pN\\p{Pc}]+");
		integerPattern = Pattern.compile("^[0-9]+");
		emojiPattern = Pattern.compile("^[\uD83C-\uDBFF\uDC00-\uDFFF]+");
		//unicode characters and emojis and numbers probably????
		idPattern = Pattern.compile("^[_\\pL\\pN\\p{Pc}\uD83C-\uDBFF\uDC00-\uDFFF][_\\pL\\pN\\p{Pc}0-9\uD83C-\uDBFF\uDC00-\uDFFF]*");
		numberPattern = Pattern.compile("^[0-9]+(\\.[0-9]+)?(e[0-9]+)?");
		//wftf
		stringPattern = Pattern.compile("^('(\\\\'|[^'])*'|\"(\\\\\"|[^\"])*\")");
		whitespacePattern = Pattern.compile("^[ \t]+");
		endOfLinePattern = Pattern.compile("^\\s*?(\n|$)");
	}
	
	
	public void setBacktrackPoint(){
		backtrackPoints.push(position);
	}
	
	public void backtrack(){
		position = backtrackPoints.pop();
	}
	
	public void clearBacktrack(){
		backtrackPoints.pop();
	}
	
	public String getString(String c){
		if (source.substring(position, position + c.length()).equals(c)){
			position += c.length();
			return c;
		}
		return null;
	}
	
	public String getOption(String[] options){
		for (int i = 0; i < options.length; i++){
			String result = getString(options[i]);
			if (result != null){
				return result;
			}
		}
		return null;
	}
	
	public String getPattern(Pattern p){
		Matcher m = p.matcher(source.substring(position));
		boolean found = m.find();
		if (found){
			String group = m.group(0);
			position += group.length();
			return group;
		}
		return null;
	}
	
	public String getEndOfLine(){
		return getPattern(endOfLinePattern);
	}
	
	public String getWhitespace(){
		return getPattern(whitespacePattern);
	}
	
	public String getIdentifier(){
		return getPattern(idPattern);
	}
	
	public String getAlpha(){
		//gttttffffffffffffffffffffffffffffffffffffffrrcvmj 
		return getPattern(alphaPattern);
	}
	
	public String getInteger(){
		return getPattern(integerPattern);
	}
	
	public String getNumber(){
		return getPattern(numberPattern);
	}
	
	public String getStringLiteral(){
		return getPattern(stringPattern);
	}
	
	public String getEmoji(){
		return getPattern(emojiPattern);
	}
	
	public boolean isEndOfFile(){
		return position == source.length();
	}
}
