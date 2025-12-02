package br.com.eetepa.EndPoints;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.eetepa.ConexaoBanco.ListarDadosDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ListarDados")
public class ListarDadosServlet extends HttpServlet {

  private ObjectMapper mapper = new ObjectMapper();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;charset=UTF-8");

    ListarDadosDAO listarDadosDAO = new ListarDadosDAO();

    try {
      // Agora estamos enviando um OBJETO, que é convertido em JSON corretamente
      mapper.writeValue(response.getOutputStream(), listarDadosDAO.listarDados());

    } catch (Exception e) {
      response.setStatus(500);
      response.getWriter().write("{\"erro\": \"" + e.getMessage() + "\"}");
    }
  }
}
