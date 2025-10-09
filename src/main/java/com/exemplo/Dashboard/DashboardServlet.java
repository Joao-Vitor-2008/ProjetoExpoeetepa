package com.exemplo.Dashboard;

import com.exemplo.Estacao.EstacaoManager;
import com.exemplo.Irrigador.IrrigadorManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    // Cria um JSON com irrigadores e estacoes
    Map<String, Object> dados = new HashMap<>();
    dados.put("irrigadores", IrrigadorManager.getInstance().getTodos());
    dados.put("estacoes", EstacaoManager.getInstance().getTodos());

    response.setContentType("application/json;charset=UTF-8");
    mapper.writeValue(response.getOutputStream(), dados);
  }
}
