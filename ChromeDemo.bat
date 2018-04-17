D:
set projectLocation=D:\BSI_FW\BSI\BSI.Automation.Regression
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\DemoChrome.xml
pause