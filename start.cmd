@echo off
@REM Copyright (c) 2000 Pedro Alcazar, Inc. All Rights Reserved.

@REM Adjust these variables to match your environment
set STARTCLASS=com.javamercenary.ai.inferenczy.core.Boot

set PATH=%PATH%;c:\jbuilder4\jdk1.3\bin
if "" == "%JAVA_HOME%" set JAVA_HOME=c:\jbuilder4\jdk1.3

set MYCLASSPATH=%JAVA_HOME%\lib\classes.zip;./lib/parser.jar;.

echo running %STARTCLASS%
java -classpath %MYCLASSPATH% %STARTCLASS%

pause
