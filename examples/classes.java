public class classes
{
	public class testSquare
	{
		public Object x;
		public testSquare(Object x)
		{
			this.x = ((int)x)*2;
		}
		
		public static Object fooBar(Object x)
		{
			return ((int)x)*2;
		}
	}
	
	public static void main(String[] args)
	{
		testSquare mySquare = new testSquare(12);
		System.out.println(mySquare.x);
		System.out.println(testSquare.fooBar(12));
	}
}