# myhome_jpa_basic - Maven -> Gradle 변환 스크립트

$projectDir = "C:\springboot_workspace\myhome_jpa_basic"

Write-Host "====================================" -ForegroundColor Cyan
Write-Host " Maven -> Gradle 변환 시작" -ForegroundColor Cyan
Write-Host "====================================="

# 1. gradle/wrapper 폴더 생성
New-Item -ItemType Directory -Force -Path "$projectDir\gradle\wrapper" | Out-Null
Write-Host "[1/5] gradle/wrapper 폴더 생성 완료" -ForegroundColor Green

# 2. gradle-wrapper.properties 생성
$wrapperProps = @"
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-8.5-bin.zip
networkTimeout=10000
validateDistributionUrl=true
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
"@
$wrapperProps | Set-Content "$projectDir\gradle\wrapper\gradle-wrapper.properties" -Encoding UTF8
Write-Host "[2/5] gradle-wrapper.properties 생성 완료" -ForegroundColor Green

# 3. gradlew (Linux/Mac 용) 생성
$gradlew = @'
#!/bin/sh
APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`
APP_HOME=`pwd -P`
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar
exec "$JAVACMD" "$@" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
'@
$gradlew | Set-Content "$projectDir\gradlew" -Encoding UTF8 -NoNewline
Write-Host "[3/5] gradlew 생성 완료" -ForegroundColor Green

# 4. gradlew.bat (Windows 용) 생성
$gradlewBat = @'
@rem Gradle startup script for Windows
@if "%DEBUG%"=="" @echo off
@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal
set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar
@rem Execute Gradle
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
if "%ERRORLEVEL%"=="0" goto mainEnd
:fail
exit /b 1
:mainEnd
if "%OS%"=="Windows_NT" endlocal
'@
$gradlewBat | Set-Content "$projectDir\gradlew.bat" -Encoding UTF8
Write-Host "[4/5] gradlew.bat 생성 완료" -ForegroundColor Green

# 5. pom.xml 백업
if (Test-Path "$projectDir\pom.xml") {
    Rename-Item "$projectDir\pom.xml" "$projectDir\pom.xml.bak" -Force
    Write-Host "[5/5] pom.xml -> pom.xml.bak 백업 완료" -ForegroundColor Green
} else {
    Write-Host "[5/5] pom.xml 없음 (건너뜀)" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "====================================" -ForegroundColor Cyan
Write-Host " 변환 완료!" -ForegroundColor Cyan
Write-Host "====================================="
Write-Host ""
Write-Host "생성된 파일:" -ForegroundColor White
Write-Host "  build.gradle" -ForegroundColor Gray
Write-Host "  settings.gradle" -ForegroundColor Gray
Write-Host "  gradle/wrapper/gradle-wrapper.properties" -ForegroundColor Gray
Write-Host "  gradlew / gradlew.bat" -ForegroundColor Gray
Write-Host ""
Write-Host "인텔리제이에서 프로젝트 열기:" -ForegroundColor Yellow
Write-Host "  File -> Open -> myhome_jpa_basic 폴더 선택" -ForegroundColor Yellow
Write-Host "  build.gradle 파일로 열면 자동으로 Gradle 프로젝트로 인식됩니다." -ForegroundColor Yellow
Write-Host ""
pause
