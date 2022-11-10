#!/bin/bash
# Create your grading script here
#set -e
CPATH=".:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar"
rm -rf student-submission
git clone $1 student-submission

cp TestListExamples.java student-submission/
# In student submission
cd student-submission

LISTFILE=`find ListExamples.java`
if [[ -e $LISTFILE ]]
then
    echo "List Examples Exists"
else
    echo "Uh oh you forgot to make the one file you needed"
    exit 1
fi

javac -cp $CPATH *.java 
if [[ $? -ne 0 ]]
then
    echo "Compile Unsuccessful Grade: F (For Feel Bad)"
    exit 1
else
    echo "It compiled"
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples

if [[ $? -ne 0 ]]
then
    echo "You didn't pass, retake Math 4"
else
    echo "Probably not a failure"
fi

