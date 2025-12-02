#!/bin/zsh

./ArduinoApp/deploy.sh || echo "Erro Ao executar o deploy do ArduinoApp"

./WebApp/deploy.sh || echo "Erro Ao executar o deploy do WebApp"
