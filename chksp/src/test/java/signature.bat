rem set JRE=C:\Program Files (x86)\Java\jdk1.8.0_60
set CLASSPATH=.;../lib;./bin;../jars/trusted_java20.jar;../jars/junit.jar;../jars/commons-logging.jar

set DEFAULT_JVM_OPTS="-Dorg.apache.xml.security.resource.config=resource/tj-msxml.xml"


rem "%JRE%/bin/java" -jar chksp-0.0.1-SNAPSHOT-jar-with-dependencies.jar -list -storename CurrentUser/My
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

"%JAVA_EXE%" %DEFAULT_JVM_OPTS% -jar chksp-0.0.1-SNAPSHOT.jar -sign -in check7.xml -out out.xml -element dogovor -alias SCARD\rutoken_311550ac\0A00\82F9
rem "%JAVA_EXE%" -jar chksp-0.0.1-SNAPSHOT.jar -sign -in check4.xml -out out.xml -element checkMe -alias SCARD\rutoken_33124d15\0A00\1F70
rem "%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SIGNATURE_DEMO_OPTS%  -classpath "%CLASSPATH%" ru.gosuslugi.dom.signature.demo.Start %CMD_LINE_ARGS%


