@echo off
setlocal enabledelayedexpansion

echo Starting clean and package process for all microservices...
echo.

:: Define microservices
set services=billing-service customer-service inventory-service api-gateway config-service discovery-service
set failed=

:: Process each service
for %%s in (%services%) do (
    echo.
    echo ========================================
    echo Processing %%s...
    echo ========================================

    if exist "%%s" (
        cd %%s

        echo Cleaning %%s...
        call mvn clean

        if errorlevel 1 (
            echo ERROR: %%s cleaning failed!
            set failed=!failed! %%s
        ) else (
            echo Packaging %%s...
            call mvn package -DskipTests

            if errorlevel 1 (
                echo ERROR: %%s packaging failed!
                set failed=!failed! %%s
            ) else (
                echo SUCCESS: %%s packaged successfully!
            )
        )

        cd ..
    ) else (
        echo ERROR: Directory %%s not found!
        set failed=!failed! %%s
    )
)

:: Summary
echo.
echo ========================================
echo Build Summary
echo ========================================

if "!failed!"=="" (
    echo All microservices built successfully!
    exit /b 0
) else (
    echo Failed services:!failed!
    exit /b 1
)