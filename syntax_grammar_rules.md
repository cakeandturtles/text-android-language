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
	this
	public
	private
	protected #does java have this?
	is
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
	#also allow separation by whitespace
	#the only reason this is important is because google keyboard automatically puts space between words under default settings, so it's really hard to camelCase variable names, and having to switch screens to use "_" for most variable names reduces efficiency
	#e.g. valid func name	#this function name is identical
	#e.g. valid		func name	#to this function name, in terms of parsing
	
	#limitation: any whitespace separated word of a variable/function may NOT be a keyword
	
variable assignment:
	valid variable name is valid_value
	#e.g. a is 3
	#e.g. _x is a
	#e.g. emoji is "hello, world"
	#e.g. valid vari name is true
	
function definition:
	def valid function name
		#any valid statements can go here
	end
	
	#alternatively, can separate definition with colon if you don't want to newline
	def foo bar: end
	
	#a function definition separates parameters with a "," indicating that parameters will now start
	#commas can be immediately after variable name, or separated by whitespace
	def foo bar, x, y , another param
		return x plus y plus another param
	end

in order to call a function, simply name it after defining it:
	#e.g. def foo bar: end
	#     foo bar
	#if the function has parameters, simply pass arguments similar to the parameter definition
	
	def foo bar, x, y, another param: end
	foo bar , 3, 2 , 16
	
	#this also works with built-in provided functions
	print, "hello, world"
	
	#note, if value provided as argument is a primitive value instead of a variable name, it is acceptable to leave off commas
	print "hello, world"
	x is 2
	foo bar 3 x 16
	
class definition:
	#attribute declarations
	public name
	public species type
	private secret name
	
	class special doggo
		#same as a function definition, but same name as class
		#to indicate constructor
		def special doggo, name	, species
			this. name is name
			this. species type is species
			this. secret name is name plus 'secret'
		end
		
		#static class methods work just like java
		#are indicated by the "static" keyword in front of def
		static def bark
			print "ruff!!!!!"
		end
	end
	
	#'this' keyword refers to the object instance
	#notice that we are using "this. x" instead of "this.x"
	#this is because google keyboard will by default put a space after periods
	#so we just eat any whitespace after a period and interpret it as an object attribute/method reference
	
class instantiation:
	my dog is special doggo, "edward", "caribo type pokemon"
	
	#attribute accessing
	print "name: " plus my dog. name
	print, "species: " + my dog. species type
	
