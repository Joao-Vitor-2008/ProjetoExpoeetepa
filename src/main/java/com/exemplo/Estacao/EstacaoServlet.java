package com.exemplo.Estacao;

import com.exemplo.ConexaoBanco.EstacaoDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/estacao")
public class EstacaoServlet extends HttpServlet {
  private EstacaoManager manager = new EstacaoManager();
  private final ObjectMapper mapper = new ObjectMapper();
  private EstacaoDAO estacaoDAO = new EstacaoDAO();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.getWriter().write("{\"status\":\"use POST para enviar dados\"}");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Estacao estacao = mapper.readValue(req.getInputStream(), Estacao.class);

    estacaoDAO.inserirDadosEstacao(estacao);

    manager.updateEstacao(estacao);
  }
}
