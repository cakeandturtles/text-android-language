public class events extends Activity
{
	@Override
	public boolean dispatchKeyEvent(KeyEvent event)
	{
		int action = event.getAction();
		int keyCode = event.getKeyCode();
		switch(keyCode){
			case KeyEvent.KEYCODE_VOLUME_UP:
				if (action == KeyEvent.ACTION_UP){
					System.out.println("volume up button pressed");
				}
				return true;
			default:
				return super.dispatchKeyEvent(event);
		}
	}
	
	public static void main(String[] args)
	{
	}
}