@echo off

REM Ottenere la data e l'ora attuali
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

REM Formattare la data e l'ora
set "formatted_date=%year%-%month%-%day%"
set "formatted_time=%hour%:%minute%"

REM Eseguire il commit con il messaggio contenente la data e l'ora
git commit -a -m "%formatted_date% %formatted_time%"
rem git commit -a -m "Update to 1.8"
git push

REM Visualizzare l'output del commit
echo Commit eseguito con successo.