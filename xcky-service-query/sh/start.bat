title xcky-service-query
@echo off
setlocal enabledelayedexpansion
set myJar=conf
for /f %%i in ('dir /b .\lib\xcky-service-query*.jar') do (
	set myJar=!myJar!;lib/%%i
)	
java -cp %myJar% com.hisign.xcky.service.main.ServiceProvider
pause