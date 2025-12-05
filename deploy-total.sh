#!/bin/zsh
./ArduinoApp/deploy.sh || echo "Erro Ao executar o deploy do ArduinoApp"

./WebApp/deploy.sh || echo "Erro Ao executar o deploy do WebApp"

cd /home/$(whoami)/git/Projeto-Expoeetepa-Irrigadores-Automaticos/docker-data/

sudo docker compose down

sleep 3

sudo docker compose up -d
