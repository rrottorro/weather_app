package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.LongitudeLatitude;
import com.example.demo.service.WeatherForcastService;

@Controller
public class WeatherForecastController {

	@RequestMapping(value = "/weather_forecast", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String weatherForecast(@RequestBody LongitudeLatitude longitudeLatitude, Model model) {

		System.out.println("WeatherForecastController");
//		System.out.println("緯度：" + longitudeLatitude.getLatitude());
//		System.out.println("経度：" + longitudeLatitude.getLongitude());

		WeatherForcastService weatherForcastService = new WeatherForcastService();
		weatherForcastService.getWether(longitudeLatitude.getLatitude(), longitudeLatitude.getLongitude());

		System.out.println("WeatherForecastController：値取得");

		// 取得した値を、viewにセット

		return "weather_forecast";
	}

}