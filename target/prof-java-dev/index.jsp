<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style type="text/css">
.top-buffer {
	margin-top: 20px;
}
</style>

</head>
<body>

	<div class="col-md-10">
		<form accept-charset="UTF-8" name="formSearchWeather" role="form"
			action="/prof-java-dev/WeatherServlet" target="_blank">

			<h2>Weather App</h2>

			<div class="col-md-2">
				<div class="row top-buffer">
					<input class="form-control" type="text" id="location"
						name="location" placeholder="location (name or zip)" />
				</div>
				<div class="row top-buffer">
					<input class="form-control" type="text" id="country" name="country"
						placeholder="country (iso code)" />
				</div>
				<div class="row top-buffer">
					<input class="btn btn-outline-primary" type="submit" id="btnGetWeather" value="Get Weather" />
				</div>
			</div>

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		</form>
	</div>
</body>
</html>

