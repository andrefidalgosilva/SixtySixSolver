package sixtysixsolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @author André Silva (GitHub @Andrefpvs)
 */

public class SixtySixSolver {

	// HINT
	// Using arguments such as "number of operations", "type of operation"
	// and "expected result", it's not hard to modify this program to find
	// any solution for any multiple-variable equation result.
	//
	// This program will focus only on solving the problem detailed here:
	// http://www.theguardian.com/science/alexs-adventures-in-numberland/2015/may/20/can-you-do-the-maths-puzzle-for-vietnamese-eight-year-olds-that-has-stumped-parents-and-teachers
	// It will output every solution possible. Setting output to a text
	// file is recommended!
	//
	// Possible args: -onlyone
	//				  -random
	//				  -noparse
	//				  -perfectsolutions
	
	private static ArrayList<Solution> solutions = new ArrayList<Solution>();
	private static ArrayList<Solution> perfectSolutions = new ArrayList<Solution>();
	private static int numberOfSolutions = 0;
	private static int numberOfPerfectSolutions = 0;
	
	public static void main(String[] args) {
		// handle arguments
		boolean onlyOneSolution = false;	
		boolean noParse = false;
		boolean random = false;
		boolean perfectSolution = false;
		int randomSolutionID = 1;
        if (args.length != 0) {
        	if(args.length > 1) {
        		System.out.println("Please use only one argument. "
        				+ "Trying only argument " + args[0] + ".");
    			try {
    			    Thread.sleep(1200);
    			} catch(InterruptedException ex) {
    			    Thread.currentThread().interrupt();
    			}
        	}
			onlyOneSolution = (args[0].equals("-onlyone"));
			noParse = (args[0].equals("-noparse"));
			random = (args[0].equals("-random"));
			perfectSolution = (args[0].equals("-perfectsolutions"));
			if(!args[0].equals("-onlyone")
					&& !args[0].equals("-noparse")
					&& !args[0].equals("-random")
					&& !args[0].equals("-perfectsolutions")) {
				System.out.println("Invalid argument. Running with no arguments...");
				try {
    			    Thread.sleep(1200);
    			} catch(InterruptedException ex) {
    			    Thread.currentThread().interrupt();
    			}
			}
		}
		
		long startTime = System.nanoTime();
		boolean foundSolution = false;
		
		System.out.println("Gathering solutions... please wait.");
		
		loopstart:
		for(int a = 1; a <= 9; a++)
			for(int b = 1; b <= 9; b++)
				for(int c = 1; c <= 9; c++)
					for(int d = 1; d <= 9; d++)
						for(int e = 1; e <= 9; e++)
							for(int f = 1; f <= 9; f++)
								for(int g = 1; g <= 9; g++)
									for(int h = 1; h <= 9; h++)
										for(int i = 1; i <= 9; i++)
											if(equationEquals66(a, b, c, d, e, f, g, h, i)) {
												solutions.add(new Solution(a, b, c, d, e, f, g, h, i));
												foundSolution = true;
												numberOfSolutions++;
												if(noParse)
													System.out.println("SOLUTION no. "
															+ numberOfSolutions + ":\n"
															+ a + " + 13 * " + b
															+ " / " + c + " + "
															+ d + " + 12 * " + e
															+ " - " + f + " - 11 + "
															+ g + " * " + h + " / "
															+ i + " - 10 = 66\n");
												if(onlyOneSolution) break loopstart;
												if(perfectSolution
														&& allDifferent(a, b, c, d, e, f, g, h, i)) {
													perfectSolutions
														.add(new Solution(a, b, c, d, e, f, g, h, i));
													numberOfPerfectSolutions++;
												}
											}
		
		
		if(noParse) {
			long endTime = System.nanoTime();
			long timeTaken = (endTime - startTime);
			System.out.println("\nTime taken: " + (timeTaken / 1000000000) + " seconds.");
			return;
		}
		
		if(random && foundSolution && numberOfSolutions > 1) {
			Random rng = new Random();
			randomSolutionID = rng.nextInt((numberOfSolutions - 1)) + 1;
			Solution randomSolution = solutions.get(randomSolutionID);
			System.out.println("\nFound solutions! Random solution requested."
					+ "\nOutputting solution number " + randomSolutionID + ".");
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println("SOLUTION: \n"
					+ randomSolution.getA() + " + 13 * " + randomSolution.getB()
					+ " / " + randomSolution.getC() + " + "
					+ randomSolution.getD() + " + 12 * " + randomSolution.getE()
					+ " - " + randomSolution.getF() + " - 11 + "
					+ randomSolution.getG() + " * " + randomSolution.getH() + " / "
					+ randomSolution.getI() + " - 10 = 66\n");
			long endTime = System.nanoTime();
			long timeTaken = (endTime - startTime);
			System.out.println("\nTime taken: " + (timeTaken / 1000000000) + " seconds.");
			return;
		}
		
		if(perfectSolution) {
			System.out.println("\nFound solutions! "
					+ "Only perfect solutions requested (no digits repeated).");
			try {
			    Thread.sleep(2000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			System.out.println("PERFECT SOLUTIONS: ");
			for(Solution s : perfectSolutions) {
				System.out.println("PERFECT SOLUTION: \n"
						+ s.getA() + " + 13 * " + s.getB()
						+ " / " + s.getC() + " + "
						+ s.getD() + " + 12 * " + s.getE()
						+ " - " + s.getF() + " - 11 + "
						+ s.getG() + " * " + s.getH() + " / "
						+ s.getI() + " - 10 = 66\n");
			}
			long endTime = System.nanoTime();
			long timeTaken = (endTime - startTime);
			System.out.println("\nNumber of perfect solutions found: " + numberOfPerfectSolutions);
			System.out.println("\nTime taken: " + (timeTaken / 1000000000) + " seconds.");
			return;
		}
		
		if(foundSolution) {
			System.out.println("\nFound solutions! Outputting solutions...");
			try {
			    Thread.sleep(2000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			System.out.println("SOLUTIONS: ");
			for(Solution s : solutions) {
				System.out.println("SOLUTION: \n"
						+ s.getA() + " + 13 * " + s.getB()
						+ " / " + s.getC() + " + "
						+ s.getD() + " + 12 * " + s.getE()
						+ " - " + s.getF() + " - 11 + "
						+ s.getG() + " * " + s.getH() + " / "
						+ s.getI() + " - 10 = 66\n");
			}
			long endTime = System.nanoTime();
			long timeTaken = (endTime - startTime);
			System.out.println("\nNumber of solutions found: " + numberOfSolutions);
			System.out.println("\nTime taken: " + (timeTaken / 1000000000) + " seconds.");
			
		} else System.out.println("--No solutions found.");	
				
	}
	
	private static boolean equationEquals66(int a, int b, int c,
											int d, int e, int f,
											int g, int h, int i) {
		boolean result = false;
		
		try {
			result = ((a + 13 * (double)b / c + d + 12 * e - f - 11 + g * (double)h / i - 10) == 66);
		} catch (ArithmeticException ae) { //this is here in the unlikely event of a zero division
			return false;
		}
		
		return result;
	}
	
	private static boolean allDifferent(int a, int b, int c,
										int d, int e, int f,
										int g, int h, int i) {
		return new HashSet<Integer>(Arrays.asList(a, b, c, d, e, f, g, h, i)).size() == 9;
	}
}
