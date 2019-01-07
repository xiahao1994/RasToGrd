@echo off 
set file=%~n1
echo 该文件所在位置为%file% 
java -jar RasToGrd-1.0-SNAPSHOT-jar-with-dependencies.jar %file%.Ras
echo 转换已完成
pause
