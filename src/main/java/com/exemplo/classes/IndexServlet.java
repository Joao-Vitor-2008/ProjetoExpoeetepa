package com.exemplo.classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/statusHtml")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String html = """
        <!DOCTYPE html>
        <html lang="pt-BR">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Status dos Dispositivos</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    padding: 20px;
                    background-color: #fafafa;
                }
                h1 {
                    color: #333;
                }
                button {
                    padding: 8px 15px;
                    margin-bottom: 15px;
                    border: none;
                    background-color: #007BFF;
                    color: white;
                    border-radius: 5px;
                    cursor: pointer;
                }
                button:hover {
                    background-color: #0056b3;
                }
                table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 15px;
                }
                th, td {
                    padding: 10px;
                    border: 1px solid #ddd;
                    text-align: center;
                }
                th {
                    background-color: #f0f0f0;
                }
                .loading {
                    color: #666;
                    font-style: italic;
                }
                .error {
                    color: red;
                    font-weight: bold;
                }
            </style>
        </head>
        <body>
            <h1>Status dos Dispositivos</h1>
            <button onclick="carregar()">Atualizar</button>
            <div id="conteudo" class="loading">Carregando...</div>

            <script>
                let refreshInterval;

                async function carregar() {
                    const conteudo = document.getElementById("conteudo");
                    try {
                        const resp = await fetch("status");
                        if (!resp.ok) throw new Error("Erro na requisição");
                        
                        const dados = await resp.json();
                        if (Object.keys(dados).length === 0) {
                            conteudo.innerHTML = "<p class='loading'>Nenhum dispositivo conectado.</p>";
                            return;
                        }

                        let tabela = "<table><tr><th>ID</th><th>Temperatura</th><th>Umidade</th><th>Comando</th></tr>";
                        for (let id in dados) {
                            let d = dados[id];
                            tabela += `
                                <tr>
                                    <td>${d.id || "N/A"}</td>
                                    <td>${d.temperatura != null ? d.temperatura + "°C" : "N/A"}</td>
                                    <td>${d.umidade != null ? d.umidade + "%" : "N/A"}</td>
                                    <td>${d.comando || "Nenhum"}</td>
                                </tr>`;
                        }
                        tabela += "</table>";
                        conteudo.innerHTML = tabela;
                    } catch (error) {
                        conteudo.innerHTML = "<div class='error'>Erro ao carregar dados</div>";
                    }
                }

                // Carregar imediatamente ao abrir a página
                carregar();
                // Atualizar automaticamente a cada 2 segundos
                refreshInterval = setInterval(carregar, 2000);
            </script>
        </body>
        </html>
        """;

        resp.getWriter().write(html);
    }
}
