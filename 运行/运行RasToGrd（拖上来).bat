@echo off 
set file=%~n1
echo ���ļ�����λ��Ϊ%file% 
java -jar RasToGrd-1.0-SNAPSHOT-jar-with-dependencies.jar %file%.Ras
echo ת�������
pause
