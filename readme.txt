COS126 Final Project: Implementation

Please complete the following questions and upload this readme.txt to the
TigerFile assignment for the "Final Project Implementation".


/**********************************************************************
 * Basic Information                                                  *
 **********************************************************************/

Name 1: Alexander Yoo

NetID 1: ay6496

Name 2: David Oke

NetID 2: do6051

Project preceptor name: Alfredo Velasco

Project title: FreshmanSim

CodePost link for proposal feedback: https://codepost.io/code/507054

Link to project video:

Approximate number of hours to complete the final project
Number of hours:

/**********************************************************************
 * Required Questions                                                 *
 **********************************************************************/

Describe your project in a few sentences.

Our project is a text-based role playing game that simulates the life of a
first-year Princeton Universitty student. This includes social activities,
assignments and exams, and some interesting events!




Describe in detail your three features and where in your program
they are implemented (e.g. starting and ending line numbers,
function names, etc.).

1.

The Person class (called 'Player' in the proposal) is defined in Person.java.
This class includes 5 player attributes defined as instance variables, these are:
the player's health, happiness, bank, intelligence, and charisma. There are 11
methods defined in this class (excluding the constructor), namely:
incrementHappiness(), incrementHealth(), incrementIntelligence(),
incrementCharisma(), getBank(), getHealth(), getHappiness, getIntelligence(),
getCharisma() and a toString and main method.
In the main method, every function listed above is called.

In FreshmanSim, the client for our program, a Person object is created to
represent the main player, and the above functions are called as a result
of the player's actions. For example, skipping a social event will call
incrementCharisma() and the charisma variable for that player will be decreased.

2.

The Grades, Course and Assignment classes ("Course selection class" in the proposal),
represent the course selection process, the calculation of a player's overall GPA,
and the generation of assignments, Grades.java includes the definition of Grades,
Course.java the definition of Course and Assignment.java the definition for Assignment.

Grades has one instance variable, 3 static methods and a main method. The
instance variable is an ArrayList of Assignment objects (Assignment is a class
defined in Assignment.java). The 3 static methods are addAssignment(),
scoreAssignment(), and calculateGPA(). In the main method, every function listed
above is called.

Course has one instance variable, one constructor, one method and a main method.
The instance variable is a string cName, that defines the AB or BSE path. The
method is getName() and it is called in the main method.

Assignment has 5 instance variables, a constructor, and 8 methods with a main method.
The instance variables are assignmentType, assignmentTopic, assignmentMessage,
tier, and score. The 8 methods consist of getter methods for each instance variable
and a setScore() method. There is also a static generateAssignment() method. The
main method tests all of the functions.

In FreshmanSim, the client for our program, a Course object is initally created
based on the user's preference of an AB or BSE course load. AB or BSE-type Assignments
are then generated using generateAssignment() and shown to the user. A Grades object
is not created as the related methods are static. The methods in the Grades class
are used mainly on Assignment objects in the FreshmanSim client. For example,
Grades.scoreAssignment() takes in an assignment as an argument (among other
arguments) and calls setScore() (of the Assignment class) to grade the assignment
based on how much time the user allocates for the assignment.


3.

The Event class (described by "Social Life" in the proposal) is defined in
Event.java. It includes 5 instance variables, two constructors, 7 methods and a
main method. The 5 instance variables are the eventMessage, the description, the
cost of the event, whether or not it is a voluntary event, and the number of hours
of an involuntary event. The constructors vary based on whether or not the event
is voluntary. An involuntary event includes an hours argument that denotes how
long the event must take. The remaining methods are getter and setter methods as
well as an isVoluntary() method, a toString() and a generateEvent() method. The
main method calls all of the defined method.

In FreshmanSim, the client for our program, an Event is similar to an Assignment.
Event objects are created at the start of every day and the user chooses whether
or not to attend the event (if it is a voluntary event) based on the number
of hours they commit to it. Skipping events decreases a player's charisma and
attending an event increases charisma but costs money. To generate an assignment,
a string is pseudo-randomly customized based on the player's charisma.



Describe in detail how to compile and run your program. Include a few example
run commands and the expected results of running your program. For non-textual
outputs (e.g. graphical or auditory), feel free to describe in words what the
output should be or reference output files (e.g. images, audio files) of the
expected output.

To compile and run this program, the user compiles and runs FreshmanSim from the
command-line. The expected result of this is a text-based opening screen which includes a
welcome message, instructions and the option to choose your difficulty level.
Once the difficulty level is chosen, a concentration area is chosen, and events
and assignments are then generated.



Describe how your program accepts user input and mention the line number(s) at
which your program accepts user input.

The program accepts user input from the command line in FreshmanSim.java at lines
37, 61, 81, 96, 153, 158, 191, 207. This input is used to determine the way that
the game unfolds.




Describe how your program produces output based on user input (mention line
numbers).

Since this is a text-based RPG, output is very abdundant throughout FreshmanSim.
In the main method, there is output that confirms the user's input and improves
readability. When the user inputs a choice for the number of hours to spend on each
assignment or at an event and gets through the day, there is an "End of Day" output
(102 - 145) that depends on the player's attribute levels.



Describe the data structure your program uses and how it supports your program's
functionality (include the variable name and the line number(s) at which it is
declared and initialized).

Our program uses arrays to store the mutable parts of the event and assignment
statements. Examples of this are in lines 57, 66 and 72, of Event.java and 55, 62,
66, and 72 of Assignment.java. Other data structures used include an ArrayList,
in Grades.java at line 6.


List the two custom functions written by your project group, including function
signatures and line numbers; if your project group wrote more than two custom
functions, choose the two functions that were most extensively tested.
1.

2.

List the line numbers where you test each of your two custom functions twice.
For each of the four tests (two for each function), explain what was being
tested and the expected result. For non-textual results (e.g. graphical or
auditory), you may describe in your own words what the expected result
should be or reference output files (e.g. images, audio files).
1.

2.

3.

4.

/**********************************************************************
 * Citing Resources                                                   *
 **********************************************************************/

List below *EVERY* resource your project group looked at (bullet lists and
links suffice).





Remember that you should *ALSO* be citing every resource that informed your
code at/near the line(s) of code that it informed.

Did you receive help from classmates, past COS 126 students, or anyone else?
If so, please list their names.  ("A Sunday lab TA" or "Office hours on
Thursday" is ok if you don't know their name.)
Yes or no?
No



Did you encounter any serious problems? If so, please describe.
Yes or no?
No




List any other comments here.
We loved this course, COS126 was great! It was a fun ride :)




/**********************************************************************
 * Submission Checklist                                               *
 **********************************************************************/

Please mark that you’ve done all of the following steps:
[ ] Created a project.zip file, unzipped its contents, and checked that our
    compile and run commands work on the unzipped contents. Ensure that the .zip
    file is under 50MB in size.
[ ] Created and uploaded a Loom or YouTube video, set its thumbnail/starting
    frame to be an image of your program or a title slide, and checked that
    the video is viewable in an incognito browser.
[ ] Uploaded all .java files to TigerFile.
[ ] Uploaded project.zip file to TigerFile.

After you’ve submitted the above on TigerFile, remember to do the following:
[ ] Complete and upload readme.txt to TigerFile.
[ ] Complete and submit Google Form
    (https://forms.cs50.io/de2ccd26-d643-4b8a-8eaa-417487ba29ab).


/**********************************************************************
 * Partial Credit: Bug Report(s)                                      *
 **********************************************************************/

For partial credit for buggy features, you may include a bug report for at
most 4 bugs that your project group was not able to fix before the submission
deadline. For each bug report, copy and paste the following questions and
answer them in full. Your bug report should be detailed enough for the grader
to reproduce the bug. Note: if your code appears bug-free, you should not
submit any bug reports.

BUG REPORT #1:
1. Describe in a sentence or two the bug.




2. Describe in detail how to reproduce the bug (e.g. run commands, user input,
   etc.).




3. Describe the resulting effect of bug and provide evidence (e.g.
   copy-and-paste the buggy output, reference screenshot files and/or buggy
   output files, include a Loom video of reproducing and showing the effects of
   the bug, etc.).




4. Describe where in your program code you believe the bug occurs (e.g. line
   numbers).




5. Please describe what steps you tried to fix the bug.





/**********************************************************************
 * Extra Credit: Runtime Analysis                                     *
 **********************************************************************/

You may earn a small amount of extra credit by analyzing the efficiency of one
substantial component of your project. Please answer the following questions if
you would like to be considered for the extra credit for program analysis
(remember to copy and paste your answers to the following questions into the
Google form as well for credit).

Specify the scope of the component you are analyzing (e.g. function name,
starting and ending lines of specific .java file).




What is the estimated runtime (e.g. big-O complexity) of this component?
Provide justification for this runtime (i.e. explain in your own words why
you expect this component to have this runtime performance).




Provide experimental evidence in the form of timed analysis supporting this
runtime estimate. (Hint: you may find it helpful to use command-line
arguments/flags to run just the specified component being analyzed).





/**********************************************************************
 * Extra Credit: Packaging project as an executable .jar file         *
 **********************************************************************/

You may earn a small amount of extra credit by packaging your project as an
executable .jar file. Please answer the following question if you would like to
be considered for this extra credit opportunity (remember to copy and paste your
answers to the following questions into the Google form as well for credit).

Describe in detail how to execute your .jar application (e.g. what execution
command to use on the terminal). Include a few example execution commands and
the expected results of running your program. For non-textual outputs
(e.g. graphical or auditory), feel free to describe in words what the output
should be or reference output files (e.g. images, audio files) of the expected
output.
