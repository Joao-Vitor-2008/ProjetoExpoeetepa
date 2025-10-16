package com.exemplo.Estacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/estacao")
public class EstacaoServlet extends HttpServlet {
  private EstacaoManager manager = new EstacaoManager();
  private final ObjectMapper mapper = new ObjectMapper();
  Estacao estacao = Estacao.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.getWriter().write("{\"status\":\"use POST para enviar dados\"}");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Estacao nova = mapper.readValue(req.getInputStream(), Estacao.class);

    estacao.setId(nova.getId());
    estacao.setPressaoAr(nova.getPressaoAr());
    estacao.setTemperaturaAr(nova.getTemperaturaAr());
    estacao.setUmidadeAr(nova.getUmidadeAr());

    manager.updateEstacao(estacao);
  }
}
