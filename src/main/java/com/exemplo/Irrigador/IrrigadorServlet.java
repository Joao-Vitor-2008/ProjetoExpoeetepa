package com.exemplo.Irrigador;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/irrigador")
public class IrrigadorServlet extends HttpServlet {
  private IrrigadorManager manager = new IrrigadorManager();
  private ObjectMapper mapper = new ObjectMapper();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.getWriter().write("{\"status\":\"use POST para enviar dados\"}");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Irrigador irrigador = mapper.readValue(req.getInputStream(), Irrigador.class);
    manager.updateIrrigador(irrigador);

    resp.setContentType("application/json");
    resp.getWriter().write("comando:" + manager.getComando(irrigador));
  }
}
