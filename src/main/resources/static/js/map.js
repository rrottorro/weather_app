$(function () {

/*    var areaLinks = {
        1: "javascript:void(0)",
        2: "javascript:void(0)",
        3: "http://rmtmhome.com",
        4: "http://rmtmhome.com",
        5: "http://rmtmhome.com",
        6: "javascript:void(0)",
        7: "javascript:void(0)",
        8: "javascript:void(0)",
        9: "javascript:void(0)"
    };*/

    var areas = [
        { code: 1, name: "", color: "#aaa", hoverColor: "#aaa", prefectures: [1] },
        { code: 2, name: "", color: "#aaa", hoverColor: "#aaa", prefectures: [2, 3, 4, 5, 6, 7] },
        { code: 3, name: "関東", color: "#7ecfea", hoverColor: "#b7e5f4", prefectures: [8, 9, 10, 11, 12, 13, 14] },
        { code: 4, name: "中部", color: "#7cdc92", hoverColor: "#aceebb", prefectures: [15, 16, 17, 18, 19, 20, 21, 22, 23] },
        { code: 5, name: "近畿", color: "#ffe966", hoverColor: "#fff19c", prefectures: [24, 25, 26, 27, 28, 29, 30] },
        { code: 6, name: "", color: "#aaa", hoverColor: "#aaa", prefectures: [31, 32, 33, 34, 35] },
        { code: 7, name: "", color: "#aaa", hoverColor: "#aaa", prefectures: [36, 37, 38, 39] },
        { code: 8, name: "", color: "#aaa", hoverColor: "#aaa", prefectures: [40, 41, 42, 43, 44, 45, 46] },
        { code: 9, name: "", color: "#aaa", hoverColor: "#aaa", prefectures: [47] },
    ];

    $("#map-container").japanMap({
        width: 600,
        areas: areas,
        selection: "area",
        borderLineWidth: 0.25,
        drawsBoxLine: false,
        movesIslands: true,
        showsAreaName: true,
        font: "MS Mincho",
        fontSize: 13,
        fontColor: "#777",
        fontShadowColor: "white",
        onSelect: function (data) {
			switch (data.code){
				case 3:
    				postWeatherRequest(36, 140);
    				break;
    			default:
    				alert(data.name);
			}
        }
    });

});

// 引数は緯度,経度
function postWeatherRequest(ido, keido){
	
	console.log("postWeatherRequest(js)")
	
	const obj = {"latitude":ido, "longitude":keido}

	
	
	
	
	fetch('/weather_forecast', {
  		method: "POST",
	  	headers: {
	    	"Content-Type": "application/json"
	  	},
	  	body: JSON.stringify(obj)
	})
	.catch(e => {
		console.error(e);
	});
	
	
	
/*    // jQueryのAjaxにてControllerクラスのメソッドを呼び出す
    $.ajax({
		type: 'POST',
        url: '/weather_forecast',
        data: JSON.stringify(obj),
        contentType: "application/json; charset=UTF-8"
        async: false,
        
        // Ajaxが正常終了した場合
        }).done(function(data, textStatus, jqXHR) {
			console.log("成功")
			console.log(JSON.stringify(obj))
            
        // Ajaxが異常終了した場合
        }).fail(function(jqXHR, textStatus, errorThrown ) {
            console.log("失敗")
            console.log(JSON.stringify(obj))
    });*/
}
