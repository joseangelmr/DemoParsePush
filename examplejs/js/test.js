$(document).ready(function($) {
	$("#push").click(function() {
		sendPush();
	});
});

var sendPush = function() {
	var parseAppID = "Parse Application ID";
	var parseAPIKey = "REST API Key";
	var my_msg = "Hello from JS and Ajax";
	$.ajax({
		type: 'POST',
		headers: {
			'X-Parse-Application-Id': parseAppID,
			'X-Parse-REST-API-Key': parseAPIKey
		},
		url: "https://api.parse.com/1/push",
		data: JSON.stringify({
			"where": {
				"deviceType": "android"
			},
			"data": {
				"alert": my_msg,
				"photo": "test.jpg",
				"quality": "low",
				"camera": "1"
			}
		}),
		contentType: "application/json",
		success: function(json) {
			console.log("Success!");
		},
		error: function(json) {
			console.log(json);
		}
	});
};