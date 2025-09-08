<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Monitoramento</title>
  <style>
    body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 20px; }
    h1 { color: #333; }
    ul { list-style-type: none; padding: 0; }
    li { background: #fff; margin: 8px 0; padding: 12px;
         border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
    h2 { margin-top: 20px; color: #555; }
  </style>
</head>
<body>
  <h1>Monitoramento</h1>

  <h2>Irrigadores</h2>
  <ul>
    <c:forEach var="irr" items="${irrigadores}">
      <!-- opção 1: mostrar formatado pelo toString -->
      <li>${irr.value}</li>
      <!-- opção 2: acessar direto os getters
      <li>ID: ${irr.value.id}, Umidade: ${irr.value.umidadeSolo}, Ação: ${irr.value.acaoAtual}, Tempo: ${irr.value.tempoRestante}</li>
      -->
    </c:forEach>
  </ul>

  <h2>Estações</h2>
  <ul>
    <c:forEach var="est" items="${estacoes}">
      <li>${est.value}</li>
    </c:forEach>
  </ul>
</body>
</html>

