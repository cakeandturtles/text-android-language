Work In Progress definitely::

'primitive' values:
	true
	false
	"any string"
	'any string'
	12345
	12.09
	12e9
	
keywords:
	my
	your
	public
	private
	protected #does java have this?
	is
	am
	are
	static
	def
	end
	class
	import
	when
	while
	for
	switch
	if
	else
	return
	break
	continue
	#probably missing some, haven't created many example cases yet
	
statements:
	function calls, variable assignment, instance creation #am i forgetting any?
	#statements are separated either by newline or by semicolon
	#by the way comments are indicated with a "#"
	
operators:
	#arithmetic operators
		times	# 3 times 4 #must be whitespace separated or does that not matter?
		*		# 3 * 4 ; 3*4
		plus	# 3 plus 4
		+		# 3 + 4
		minus	# 3 minus 4
		-		# 3 - 4
		div		# 3 div 4	#short for "divided by", is there something better?
		/		# 3 / 4
		mod		# 3 mod 4	#modulo
		%		# 3 % 4
		exp		# 3 exp 4 	#exponent
		**		# 3 ** 4
		#am i missing any?
		
	#string operators
		plus	#concatenation like java
		+
		
	#logical operators
		and		#true and false	#like python
		&&		#true && false #also valid
		or		#true or false
		||		#true || false
		not		#not true
		!		#!true
		#am i missing any? are nand xor and etc. included?
		
	#bitwise operators
		#these are less common i think and i also don't really know them so i am not including english words in the specification for them??
		&
		|
		~

function/variable/class names can be:
	[any unicode alphabet character or _][any unicode alphabet character or _ or 0-9]+
	#also allow emoji standard unicode ranges to be any character in above
	
variable assignment:
	valid_variable_name is valid_value
	#e.g. a is 3
	#e.g. _x is a
	#e.g. emoji is "hello, world"
	
function definition:
	def valid_function_name
		#any valid statements can go here
	end
	
	#alternatively, can separate definition with colon if you don't want to newline
	def foobar: end
	
	#a function definition separates parameters with a indicating that parameters will now start
	#commas can be immediately after variable name, or separated by whitespace
	def foobar x, y , another_param
		return x plus y plus another_param
	end

in order to call a function, simply name it after defining it:
	#e.g. def foobar: end
	#     foobar
	#if the function has parameters, simply pass arguments similar to the parameter definition
	
	def foobar x, y, another_param: end
	foobar 3, 2 , 16
	
	#this also works with built-in provided functions
	print "hello, world"
	
class definition:

	class Dog
		#attribute declarations
		public name
		public species
		
		def Dog name, species
			#same as a function definition, but same name as class
			#to indicate constructor
			this. name is name
			this.species is species
		end
			
		#static class methods work just like java
		#are indicated by the "static" keyword in front of def
		static def bark message
			print message
		end
	end
	
	#'this' keyword refers to the object instance
	#notice that we are using "this. x" instead of "this.x"
	#this is because google keyboard will by default put a space after periods
	#so we just eat any whitespace after a period and interpret it as an object attribute/method reference
	
class instantiation:
	dog is Dog "edward", "caribo type pokemon"
	
	#object function calls
	Dog. bark "hello!"
	
	#attribute accessing
	print "name: " plus dog. name
	print "species: " + dog. species
	print "species: " + dog.species
	
	
	
