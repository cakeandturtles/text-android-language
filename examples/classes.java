public class classes
{
	public class Dog
	{
		public Object name;
		public Object species;
		public Object friend;
		public Dog(Object name, Object species)
		{
			this.name = name;
			this.species = species;
		}
		
		public static Object bark(Object message, Object num_times)
		{
			for (int i = 0; i < (int)num_times; i++){
				System.out.println(message);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Dog dog = new Dog("edward", "coribo type");
		dog.bark("ruff!", 1);
		dog.friend = new Dog("david", "special doggo");
		dog.bark(dog.friend.name, 1);
		dog.bark(dog.friend.name, 2);
		dog.bark((new Dog("freddy", "doo")).name, 3);
		dog.bark((new Dog("scooby", "doo")).species, 3);
	}
}
