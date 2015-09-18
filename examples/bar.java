public class bar
{
	public static Object bar(Object x, Object y){
		return ((int)x) * ((int)y);
	}
	
	public static Object bar(Object x){
		return ((int)x)*2;
	}
	
	public static void main(String[] args){
		Object a = bar(12, 5); System.out.println(a);
		
		Object b = bar(12);
		System.out.println(b);
		
		//should throw an error
		//Object c = bar();
	}
}