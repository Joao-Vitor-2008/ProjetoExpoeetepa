#!/bin/zsh

# Configurações
PROJETO_DIR="/home/joao-vitor/git/ProjetoExpoeetepa/" # Substitua pelo caminho do seu projeto Git
TOMCAT_WEBAPPS_DIR="/var/lib/tomcat9/webapps/"           # Substitua pelo caminho do Tomcat
WAR_NAME="ProjetoExpoeetepa.war"                # Nome do .war que será gerado pelo Maven (normalmente target/*.war)

# Entrar no diretório do projeto
cd "$PROJETO_DIR" || {
  echo "Diretório do projeto não encontrado!"
  exit 1
}

# Compilar o projeto
mvn clean package || {
  echo "Falha na compilação!"
  exit 1
}

# Copiar o .war para o Tomcat
cp "target/$WAR_NAME" "$TOMCAT_WEBAPPS_DIR/" || {
  echo "Falha ao copiar o WAR!"
  exit 1
}

systemctl restart tomcat9 || echo "Erro ao recarregar o tomcat"
echo "War copiado com sucesso"

echo "Deploy concluído com sucesso!"
