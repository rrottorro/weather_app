package com.example.demo.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.charset.StandardCharsets;

import org.apache.tomcat.util.json.JSONParser;

import com.example.demo.model.WeatherForecast;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherForcastService {

	public void getWether(Float ido, Float keido) {
		try {

			System.out.println("緯度：" + ido + ", 経度：" + keido);

			String url = "https://api.open-meteo.com/v1/forecast?latitude=" + ido + "&longitude=" + keido
					+ "&hourly=weathercode&current_weather=true";

			HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();

			BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);
			HttpResponse<String> response = HttpClient.newBuilder().build().send(request, bodyHandler);
			response.body();

			ObjectMapper mapper = new ObjectMapper();
			WeatherForecast weatherForcast = mapper.readValue(response.body(), WeatherForecast.class);
			
			System.out.println("ミリ秒単位の天気予報の生成時間：" + weatherForcast.getGenerationtime_ms() + ", 経度：" + keido);

			JSONParser parser = new JSONParser(response.body());

			// 取得した値から画像を選択

		} catch (Exception e) {
			// 500
			e.printStackTrace();
		}

	}
}
