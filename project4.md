Project 4
=========

### Due Friday, November 18, 2016 - 5:00pm

The goal of this project is to implement a program that analyzes the Java files in a given directory. You will use the following features:

- Recursion
- Object-oriented Design

### Overview

For this assignment, you will write a program to *recursively* find all Java files in a specified directory and then analyze each file to determine the following: (1) the number of source lines of code ([SLOC](https://en.wikipedia.org/wiki/Source_lines_of_code)) for each class; (2) SLOC excluding comments for each class;  (3) the sum of the SLOC and SLOC excluding comments for all classes found in the directory; and (4) *invalid* classes where the name of the class specified by the class definition does not match the name of the file. 

### Requirements

For full credit, your solution **must** meet the following requirements.

1. Your program will be run as follows: `java JavaClassAnalyzer <absolute_path>`, for example `java JavaClassAnalyzer /Users/srollins/teaching/cs112/code/ClassExamplesWeek1`.
2. Your program will *recursively* traverse the directory to find *all* Java files in the specified directory or any descendant directory.
3. The output of your program will display (1) the total number of valid classes found, (2) for each class, the absolute path of the class, the SLOC, and SLOC excluding comments; (3) the total SLOC across all classes found; (4) the SLOC excluding comments across all classes found; and (5) the absolute path of all *invalid* classes found. The required formatting is shown in this example: [p4output.txt](p4output.txt)
4. The list of valid classes will be sorted in order of the total number of lines in each class from least to greatest. 
5. Your solution must handle both single and multi-line comments. Single-line comments begin with `//`. For multi-line comments, you can assume that the beginning of comment marker `/*` has only whitespace (spaces, tabs) in front of it, while the end of comment marker `*/` has only whitespace after it. 
6. The only design *requirement* is specified in requirement #1, however you will be graded on the design of your solution and you are encouraged to see the instructor to discuss your proposed design.

### Hints

When processing a single .java class file, you will need to go through the file line by line, counting both every line in the file, and every line that is not a comment line.  So, for the following file:

```
public class Test
{
   public int Q;
   // This is a comment line
   public Test() // This is not a comment line!
   {
       /* int x = 0
          int y = 4
          int z = 3 */
       Q = 3;
   }
} 
```

The line count would be 12 (since there are a total of 12 lines in the file), and the number of lines excluding comments would be 8.

If this class were defined in a file named `Test.java` it would be considered *valid*. If the file name were anything else the class would be *invalid*.

You will need to use many methods of the `String` class.

Remember that there *may* be import statements or comments at the beginning of the file.

### Submission Requirements

1. For this assignment, you will submit all Java files you implemented for this program. Your `main` method **must** be in a file `JavaClassAnalyzer.java`. It is expected that you will have several other Java classes. My solution has five total classes.
 
2. Make sure your code follows all requirements in the [Style Guidelines](https://github.com/CS112-F16/notes/blob/master/style.md).

3. Follow the instructions in the [SVN Guide](https://github.com/CS112-F16/notes/blob/master/svn_guide.md) for submitting your solution by the deadline.

4. Make sure you have submitted your work in an SVN directory: `https://www.cs.usfca.edu/svn/<username>/cs112/project4`
