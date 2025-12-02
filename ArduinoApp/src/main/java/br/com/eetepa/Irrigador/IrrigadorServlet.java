package br.com.eetepa.Irrigador;

import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.eetepa.ClassesAuxiliares.STATUS;
import br.com.eetepa.ConexaoBanco.IrrigadorDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

@WebServlet("/irrigador")
public class IrrigadorServlet extends HttpServlet {
  private IrrigadorDAO irrigadorDAO = new IrrigadorDAO();
  private IrrigadorManager manager = new IrrigadorManager();
  private ObjectMapper mapper = new ObjectMapper();
  private STATUS status = STATUS.getInstance();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.getWriter().write("{\"status\":\"use POST para enviar dados\"}");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Irrigador irrigador = mapper.readValue(req.getInputStream(), Irrigador.class);
    manager.updateIrrigador(irrigador);

    try {
      irrigadorDAO.inserirDadosIrrigador(irrigador);
    } catch (SQLException e) {
      System.err.println(e.getErrorCode());
    }

    resp.setContentType("application/json");
    resp.getWriter().write("comando:" + manager.getComando(irrigador));
    resp.getWriter().write("\nStatus" + status.getStatus());
  }
}
