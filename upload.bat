@echo off

for /f "tokens=1-3 delims=/ " %%a in ('date /t') do (
    set "day=%%a"
    set "month=%%b"
    set "year=%%c"
)

for /f "tokens=1-3 delims=: " %%a in ('time /t') do (
    set "hour=%%a"
    set "minute=%%b"
    set "second=%%c"
)

set "formatted_date=%year%-%month%-%day%"
set "formatted_time=%hour%:%minute%"

git commit -a -m "%formatted_date% %formatted_time%"

git push

echo Commit eseguito con successo.