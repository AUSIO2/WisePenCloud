@echo off
chcp 65001
echo ==========================================
echo   正在同步网关配置到开发服务器...
echo ==========================================

:: 定义变量
set SERVER_IP=wisepen-dev-server
set SERVER_USER=oriole

:: 生成一个随机的临时目录名
set TEMP_DIR=/tmp/gateway_deploy_%RANDOM%

scp -r .\gateway %SERVER_USER%@%SERVER_IP%:%TEMP_DIR%

if errorlevel 1 (
    echo [ERROR] 上传失败！请检查 IP、用户名或网络连接。
    pause
    exit /b
)

echo.
echo ==========================================
echo   正在远程执行部署脚本...
echo ==========================================

:: 使用 SSH 远程执行命令
:: (1) chmod +x: 赋予执行权限
:: (2) sed -i: 防止 Windows 换行符 (\r\n) 导致脚本报错 (非常重要!)
:: (3) ./setup_gateway.sh: 执行脚本
set REMOTE_CMD="cd %TEMP_DIR% && chmod +x setup_gateway.sh && sed -i 's/\r$//' setup_gateway.sh && ./setup_gateway.sh; cd .. && rm -rf %TEMP_DIR%"
ssh %SERVER_USER%@%SERVER_IP% %REMOTE_CMD%

echo.
echo [SUCCESS] 远程部署执行完毕！按任意键退出...
pause