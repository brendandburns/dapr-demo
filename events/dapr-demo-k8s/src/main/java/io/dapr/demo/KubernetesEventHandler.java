package io.dapr.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

public class KubernetesEventHandler {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 3000), 0);
        server.createContext("/kube-events", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String msg = "Received event";
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, msg.length());
                try (InputStream in = exchange.getRequestBody()) {
                    System.out.println("Received event: ");
                    byte[] buffer = new byte[4096];
                    for (int read = in.read(buffer); read != -1; read = in.read(buffer)) {
                        System.out.write(buffer, 0, read);
                    }
                    System.out.println();
                }
                try (OutputStream out = exchange.getResponseBody()) {
                    out.write(msg.getBytes());
                    out.close();    
                }
            }
        });
        System.out.println("Server listening on http://localhost:3000");
        server.start();
    }
}