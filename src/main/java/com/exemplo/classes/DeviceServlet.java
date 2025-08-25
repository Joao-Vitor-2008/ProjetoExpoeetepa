package com.exemplo.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/device")
public class DeviceServlet extends HttpServlet {
    private ArduinoManager manager = ArduinoManager.getInstance();
    private ObjectMapper mapper = new ObjectMapper();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\":\"use POST para enviar dados\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Converte JSON -> Device
    	Arduino device = mapper.readValue(req.getInputStream(), Arduino.class);

        // Atualiza no gerenciador
        manager.updateDevice(device);

        // Pega comando do dispositivo
        String comando = manager.getComando(device.getId());

        // Responde em JSON
        resp.setContentType("application/json");
        Map<String, String> resposta = new HashMap<>();
        resposta.put("comando", comando);
        mapper.writeValue(resp.getOutputStream(), resposta);

    }
}
