set JRE=C:\Program Files (x86)\Java\jdk1.8.0_60

set CLASSPATH=.;./bin;../jars/trusted_java20.jar;../jars/junit.jar;../jars/commons-logging.jar


rem "%JRE%/bin/java" -jar chksp-0.0.1-SNAPSHOT-jar-with-dependencies.jar -list -storename CurrentUser/My

rem "%JRE%/bin/java" -jar chksp-0.0.1-SNAPSHOT-jar-with-dependencies.jar -sign -in check2.xml -out out.xml -element signed-element -alias SCARD\rutoken_33124d15\0A00\1F70
"%JRE%/bin/java" -jar chksp-0.0.1-SNAPSHOT-jar-with-dependencies.jar -verify -in check3.xml
