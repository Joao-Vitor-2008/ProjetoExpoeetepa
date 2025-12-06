#!/bin/zsh
./WebApp/deploy.sh || echo "Erro Ao executar o deploy do WebApp"

./ArduinoApp/deploy.sh || echo "Erro Ao executar o deploy do ArduinoApp"

cd /home/joao-vitor/git/Projeto-Expoeetepa-Irrigadores-Automaticos/docker-data/

sudo docker compose down

sleep 3

sudo docker compose up -d
