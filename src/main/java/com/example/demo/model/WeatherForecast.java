package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

	// 標高
	@JsonProperty
	Float elevation;

	// 緯度
	@JsonProperty
	Float latitude;

	// 経度
	@JsonProperty
	Float longitude;

	// 現在の天気
	@JsonProperty
	Current current_weather;

	// ミリ秒単位の天気予報の生成時間
	@JsonProperty
	Float generationtime_ms;

	// タイムゾーン
	@JsonProperty
	Long utc_offset_seconds;

	// 時間配列
	@JsonProperty
	Hourly hourly;

	// 各変数の単位
	@JsonProperty
	Unit hourly_units;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	class Current {
		@JsonProperty
		Date time;

		@JsonProperty
		Integer weathercode;

		@JsonProperty
		Integer temperature;

		@JsonProperty
		Integer windspeed;

		// 風向
		@JsonProperty
		Integer winddirection;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	class Hourly {
		@JsonProperty
		List<Date> time;
		
		@JsonProperty
		List<Integer> weathercode;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	class Unit {
		@JsonProperty
		String weathercode;
		
		@JsonProperty
		String time;
	}

}
