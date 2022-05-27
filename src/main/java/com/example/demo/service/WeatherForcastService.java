package com.example.demo.service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.model.WeatherForecast;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherForcastService {

	public WeatherForecast getWether(Float ido, Float keido) {
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

			// JSONParser parser = new JSONParser(response.body());

			return weatherForcast;

		} catch (Exception e) {
			// 500
			e.printStackTrace();
			return null;
		}

	}

	public Map<String, Integer> selectImage(WeatherForecast weatherForcast) {
		
		List<Integer> selectImages = new ArrayList();
		Map<String, Integer> result = new HashMap();
		
		switch (weatherForcast.getCurrent_weather().getWeathercode()) {
		// 晴天
		case 0:
			selectImages.add(1);
			result.put("icon", 1);
			break;

		// 晴れ
		case 1:
		case 2:
			selectImages.add(2);
			result.put("icon", 2);
			break;

		case 3:
			selectImages.add(3);
			result.put("icon", 3);
			break;

		// 雨
		case 51:
		case 53:
		case 55:
		case 61:
		case 63:
		case 65:
		case 66:
		case 67:
			selectImages.add(4);
			result.put("icon", 4);
			break;

		// 雪
		case 71:
		case 73:
		case 75:
		case 77:
			selectImages.add(4);
			result.put("icon", 4);
			break;

		// にわか雨orにわか雪
		case 80:
		case 81:
		case 82:
		case 85:
		case 86:
			selectImages.add(5);
			result.put("icon", 5);
			break;

		// 雷雨
		case 95:
		case 96:
		case 99:
			selectImages.add(6);
			result.put("icon", 6);
			break;

		default:
			selectImages.add(0);
			result.put("icon", 0);
		}

		if (weatherForcast.getCurrent_weather().getTemperature() >= 25) {
			selectImages.add(7);
		}

		if (weatherForcast.getCurrent_weather().getTemperature() <= 5) {
			selectImages.add(8);
		}

		if (weatherForcast.getCurrent_weather().getWindspeed() >= 15) {
			selectImages.add(9);
		}

		if (selectImages.size() > 1) {
			Random rand = new Random();
			int num = rand.nextInt();
			num = num % selectImages.size() + 1;
			if(num <= 0) {
				result.put("image", selectImages.get(0));
			} else {
				result.put("image", num);
			}
		}
		
		if (selectImages.size() == 1) {
			result.put("image", selectImages.get(0));
		}

		return result;

	}

}
