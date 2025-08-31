package com.exemplo.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/estacao")
public class EstacaoServlet extends HttpServlet {
    private EstacaoManager manager = EstacaoManager.getInstance();
    private ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"use POST para enviar dados\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Converte JSON -> Device
    	Estacao device = mapper.readValue(req.getInputStream(), Estacao.class);

        // Atualiza no gerenciador
        manager.updateDevice(device);
    }
}
