#!/bin/bash

# Define the classpath
CPATH='.;..\lib\hamcrest-core-1.3.jar;..\lib\junit-4.13.2.jar'

# Remove the old directories if they exist
rm -rf student-submission
rm -rf grading-area

# Create the grading-area directory
mkdir grading-area

# Clone the repository
git clone $1 student-submission
echo 'Finished cloning'

# Check if the correct file was submitted
if [ ! -f student-submission/ListExamples.java ]; then
    echo "The required file was not submitted."
    exit 1
fi

# Move the necessary files to the grading-area directory
cp -r student-submission/ListExamples.java grading-area/ListExamples.java
cp -r TestListExamples.java grading-area/TestListExamples.java
cp -r lib grading-area/lib

# Compile the tests and the student's code
cd grading-area
javac -cp $CPATH ListExamples.java TestListExamples.java
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

# Run the tests and report the grade
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > output.txt

# Parse the JUnit output
grade=$(grep -o 'OK (.* tests)' output.txt)
# echo "Grade: $grade"
cat output.txt