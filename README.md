# Sixty Six Solver
## Description
	
This is a simple program to solve the "Vietnamese third grader" math problem described by VN Express and reported by The Guardian on Wednesday 20 May 2015 09.37 BST.
More information [here](http://www.theguardian.com/science/alexs-adventures-in-numberland/2015/may/20/can-you-do-the-maths-puzzle-for-vietnamese-eight-year-olds-that-has-stumped-parents-and-teachers).

Basically, the problem requires students to figure out every missing digit in the equation below. The digits may range from 1 to 9, and are represented below by the letters *a, b, c, d, e, f, g, h, i*. The result of the operation is 66.

	 | a |
	 | + |
	 | 13|
	 | * |
	 | b |
	 | / |
	 | c |
	 | + |
	 | d |
	 | + |
	 | 12|
	 | * |
	 | e |
	 | - |
	 | f |
	 | - |
	 | 11|
	 | + |
	 | g |
	 | * |
	 | h |
	 | / |
	 | i |
	 | - |
	 | 10|
	 | = |
	 | 66| <--
	 
**This program will output every solution possible**. Setting output to a text file is *very* recommended!

Finding all solutions was the main goal of this program -- not efficiency!
Therefore this program has "**O(n!)**" (factorial) complexity (with *n* restricted from 1 to 9).

__

*Actually, if you look at the program logic, you'll notice that I'm running a second loop through a "solutions" data structure, which will increase the running time of the program. This is so all solutions can be collected and parsed into a neat output structure.*

*If you want to avoid this second loop, run the program with the "-noparse" argument! :)*

__



Results when running on my machine:

	\*gigantic list of solutions\*

	Number of solutions found: 442232

	Time taken: 45 seconds.
	
If you're just looking for a single solution, here's one from the 442232 possible:

	9 + 13 * 9 / 9 + 9 + 12 * 5 - 9 - 11 + 9 * 5 / 9 - 10 = 66
	
	
## Perfect solutions

The program supports perfect solutions -- that is, solutions where every digit is different. This will output every solution to this particular subproblem (which may be the main problem, depending on your definition of the original Vietnamese problem). To only get perfect solutions, run the program with the "-perfectsolutions" argument.

Results when running on my machine:

	\*list of perfect solutions\*

	Number of perfect solutions found: 128

	Time taken: 11 seconds.
	
If you're just looking for a single perfect solution, here's one from the 128 possible:

	9 + 13 * 8 / 6 + 2 + 12 * 4 - 1 - 11 + 7 * 5 / 3 - 10 = 66


## Program arguments
	
| Argument      | Effect                                                                                      |
|---------------|---------------------------------------------------------------------------------------------|
| (none)	    | Normal program execution, every solution will be output.				      |
| -onlyone      | This will output only the first solution found (with the lowest possible values for a to i).|
| -random       | This will output only ONE solution out of all solutions found. Great for getting a different solution every time.|
| -noparse      | This will output solutions as soon as they are found, skipping the generation and handling of a Solutions structure (you might not want to print the output to a file when using this argument).|
| **-perfectsolutions** | This will output only perfect solutions (as described in the section above). **Some versions of this problem only accept perfect solutions as the answer!**|

Only one argument may be passed to the program.
 
