set ProjectPath=%CD%
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\Libs\*
echo %classpath%
java org.testng.TestNG "%ProjectPath%\Test Suites\QTiumDashboard\Demo\Part2\Windows_IE.xml"
echo .
pause