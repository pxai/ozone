@echo off
@REM Copyright (c) 2000 Pedro Alcazar, Inc. All Rights Reserved.

@REM Adjust these variables to match your environment
set CLASSES=src/core/*.java src/api/*.java src/ie/*.java

set PATH=%PATH%;c:\jbuilder4\jdk1.3\bin
if "" == "%JAVA_HOME%" set JAVA_HOME=c:\jbuilder4\jdk1.3

set MYCLASSPATH=%JAVA_HOME%\lib\classes.zip;.;c:\weblogic\lib\parser.jar

echo  Build %CLASSES% ... 
javac -d .  -classpath %MYCLASSPATH% %CLASSES%
echo  [ DONE ]
pause
