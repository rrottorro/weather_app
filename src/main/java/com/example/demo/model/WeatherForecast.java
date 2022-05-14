package com.example.demo.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {

	// 標高
	@JsonProperty
	@Getter
	Float elevation;

	// 緯度
	@JsonProperty
	@Getter
	Float latitude;

	// 経度
	@JsonProperty
	@Getter
	Float longitude;

	// 現在の天気
	@JsonProperty
	@Getter
	Current current_weather;

	// ミリ秒単位の天気予報の生成時間
	@JsonProperty
	@Getter
	Float generationtime_ms;

	// タイムゾーン
	@JsonProperty
	@Getter
	Long utc_offset_seconds;

	// 時間配列
	@JsonProperty
	@Getter
	Hourly hourly;

	// 各変数の単位
	@JsonProperty
	@Getter
	Unit hourly_units;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public class Current {
		@JsonProperty
		@Getter
		Date time;

		@JsonProperty
		@Getter
		Integer weathercode;

		@JsonProperty
		@Getter
		Integer temperature;

		@JsonProperty
		@Getter
		Integer windspeed;

		// 風向
		@JsonProperty
		@Getter
		Integer winddirection;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public class Hourly {
		@JsonProperty
		@Getter
		List<Date> time;

		@JsonProperty
		@Getter
		List<Integer> weathercode;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public class Unit {
		@JsonProperty
		@Getter
		String weathercode;

		@JsonProperty
		@Getter
		String time;
	}

}
