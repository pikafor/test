package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class First {
    @GetMapping
    public void func() {
        System.out.println("test");
        try {
            // Создание объекта URL с адресом, по которому необходимо выполнить GET-запрос
            URL url = new URL("https://laitis.ru/send?key=etr0BglqGk&phrase=%D0%BA%D1%83%D0%B7%D1%8F%20%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D1%82%D0%B8%20%D0%B8%D0%B4%D0%B5%D1%8E");

            // Создание объекта HttpURLConnection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Установка метода запроса GET
            conn.setRequestMethod("GET");

            // Получение кода ответа от сервера
            int responseCode = conn.getResponseCode();

            // Чтение ответа от сервера
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Вывод полученного ответа
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
