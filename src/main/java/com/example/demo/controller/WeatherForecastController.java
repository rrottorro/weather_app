package com.example.demo.controller;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.LongitudeLatitude;
import com.example.demo.model.WeatherForecast;
import com.example.demo.service.WeatherForcastService;

@Controller
public class WeatherForecastController {

	@PostMapping(value = "/weather_forecast")
	public String weatherForecast(LongitudeLatitude longitudeLatitude, Model model) {

		System.out.println("WeatherForecastController");
		System.out.println("緯度：" + longitudeLatitude.getLatitude());
		System.out.println("経度：" + longitudeLatitude.getLongitude());

		WeatherForcastService weatherForcastService = new WeatherForcastService();
		WeatherForecast result = weatherForcastService.getWether(longitudeLatitude.getLatitude(), longitudeLatitude.getLongitude());

		Map<String,Integer> icon = weatherForcastService.selectImage(result);
		
		
		String tem = result.getCurrent_weather().getTemperature().toString();
		
		System.out.println("気温：" + result.getCurrent_weather().getTemperature());
		System.out.println("icon：" + icon.get("icon"));
		System.out.println("image：" + icon.get("image"));

		// 取得した値を、viewにセット
		model.addAttribute("place", longitudeLatitude.getPlace());
		model.addAttribute("temperature", tem);
		model.addAttribute("icon", icon.get("icon"));
		model.addAttribute("img", icon.get("image"));
		
		return "weather_forecast";
	}

	@RequestMapping(value = "/weather_forecast", method = RequestMethod.GET)
	public String weatherForecastGet(Model model) {
		return "weather_forecast";
	}

	/*
	 * @RequestMapping(value = "/weather_forecast", method = RequestMethod.POST,
	 * consumes = MediaType.APPLICATION_JSON_VALUE) public String
	 * weatherForecast(@RequestBody LongitudeLatitude longitudeLatitude, Model
	 * model) {
	 * 
	 * System.out.println("WeatherForecastController"); System.out.println("緯度：" +
	 * longitudeLatitude.getLatitude()); System.out.println("経度：" +
	 * longitudeLatitude.getLongitude());
	 * 
	 * WeatherForcastService weatherForcastService = new WeatherForcastService();
	 * weatherForcastService.getWether(longitudeLatitude.getLatitude(),
	 * longitudeLatitude.getLongitude());
	 * 
	 * System.out.println("WeatherForecastController：値取得");
	 * 
	 * // 取得した値を、viewにセット // model.addAttribute("img",
	 * "static/img/kirby-parasol.png");
	 * 
	 * return "weather_forecast"; }
	 */

}
