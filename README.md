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

*Actually, if you look at the program logic, you'll notice that I'm running a second loop through a "solutions" data structure, which will increase the running time of the program. Why am I using that structure? Initially I had planned to do so some more things with the solutions, however...!*

*If you want to avoid this second loop, run the program with the "-noparse" argument! :)*

__



Results when running on my machine:

	\*gigantic list of solutions\*

	Number of solutions found: 3359844

	Time taken: 219 seconds.
	
If you're just looking for a single solution, here's one from the 3359844 possible:

	9 + 13 * 9 / 9 + 8 + 12 * 4 - 3 - 11 + 6 * 4 / 2 - 10 = 66


## Program arguments
	
| Argument      | Effect                                                                                      |
|---------------|---------------------------------------------------------------------------------------------|
| (none)	    | Normal program execution, every solution will be output.									  |
| -onlyone      | This will output only the first solution found (with the lowest possible values for a to i).|
| -random       | This will output only ONE solution out of all solutions found. Great for getting a different solution every time.|
| -noparse      | This will output solutions as soon as they're found, skipping the generation and handling of a Solutions structure (you might not want to print the output to a file when using this argument).|

Only one argument may be passed to the program.
 
