package engine;


public class WeatherConditions {

	public static final WeatherCondition SUN = new WeatherCondition(0,
			"Sunshine", 5, "The sunlight turned harsh!", "The sunlight faded.");
	public static final WeatherCondition RAIN = new WeatherCondition(1, "Rain",
			5, "It's raining MEOWTH and POOCHYENA!.", "The rain stopped.");
	public static final WeatherCondition HAIL = new WeatherCondition(2, "Hail",
			5, "A hailstorm now ravages the battlefield.", "The hail stopped.");
	public static final WeatherCondition SANDSTORM = new WeatherCondition(3,
			"Sandstorm", 5, "A sandstorm kicked up!", "The sandstorm subsided.");
	public static final WeatherCondition CLEAR = new WeatherCondition(4,
			"Clear", 5, "", "");
	
	public static void clearImages(){
		SUN.clearImage();
		RAIN.clearImage();
		HAIL.clearImage();
		SANDSTORM.clearImage();
	}
}
