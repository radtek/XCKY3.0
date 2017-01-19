title xcky-service-sceneCollecting
@echo off
setlocal enabledelayedexpansion
set myJar=conf
for /f %%i in ('dir /b .\lib\xcky-service-sceneCollecting*.jar') do (
	set myJar=!myJar!;lib/%%i
)	
java -cp %myJar% com.hisign.xcky.service.main.ServiceProvider
pause