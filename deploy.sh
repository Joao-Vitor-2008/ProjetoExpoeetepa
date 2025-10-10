#!/bin/zsh

# Configurações
USER_NAME=$(whoami)
TOMCAT_WEBAPPS_DIR="/var/lib/tomcat9/webapps/"        # Substitua pelo caminho do Tomcat
WAR_NAME="ProjetoExpoeetepa.war"                      # Nome do .war que será gerado pelo Maven (normalmente target/*.war)

# Entrar no diretório do projeto
 case "$USER_NAME" in
  "joao-vitor")
    PROJETO_DIR="/home/joao-vitor/git/ProjetoExpoeetepa/"
    echo "Olá "$USER_NAME"!"
    ;;
  "admin")
    PROJETO_DIR="/home/joao/git/ProjetoExpoeetepa/"
    echo "Olá "$USER_NAME"!"
    ;;
  *)
    echo "Usuário não reconhecido: $USER_NAME"
    exit 1
    ;;
esac


# Compilar o projeto
mvn clean package || {
  echo "Falha na compilação!"
  exit 1
}

# Copiar o .war para o Tomcat
sudo cp "target/$WAR_NAME" "$TOMCAT_WEBAPPS_DIR/" || {
  echo "Falha ao copiar o WAR!"
  exit 1
}
echo "War copiado com sucesso"

sudo systemctl restart tomcat9 || echo "Erro ao recarregar o tomcat"

sleep 3


# Testar o codigo automaticamente
curl -X POST http://localhost:8080/ProjetoExpoeetepa/estacao \
  -H "Content-Type: application/json" \
  -d '{
    "id": "estacao-central",
    "temperaturaAr": 32,
    "umidadeAr": 78,
    "pressaoAr": 1012
  }'

 curl -X POST http://localhost:8080/ProjetoExpoeetepa/irrigador \
  -H "Content-Type: application/json" \
  -d '{
    "id": "x",
    "umidadeSolo": 40,
    "acaoAtual": "desligado",
    "tempoRestante":0,
    "cicloDias": 3,
    "limiarUmidade": 50,
    "comando": "desligar"
  }'

echo ""
echo "Deploy concluído com sucesso!"
