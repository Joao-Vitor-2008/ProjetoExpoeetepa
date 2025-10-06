
package com.exemplo.classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/estacao")
public class EstacaoServlet extends HttpServlet {
  private final EstacaoManager manager = EstacaoManager.getInstance();
  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.getWriter().write("{\"status\":\"use POST para enviar dados\"}");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Estacao nova = mapper.readValue(req.getInputStream(), Estacao.class);

    Estacao estacao = Estacao.getInstance();
    estacao.setId(nova.getId());
    estacao.setTemperaturaAr(nova.getTemperaturaAr());
    estacao.setUmidadeAr(nova.getUmidadeAr());
    estacao.setPressaoAr(nova.getPressaoAr());

    manager.updateDevice(estacao);
  }
}
