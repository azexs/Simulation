package libraries.booster.mather;

public class Mather {
	public static float clamp(float min, float max, float value) {
		if (value >= max)
			value = max;
		else if (value <= min)
			value = min;
		return value;
	}

	public static float round(float number, int afterSymbol) {
		float multiplier = (float) Math.pow(10, afterSymbol);
		int whole = (int) (number * multiplier);
		float result = (float) whole / multiplier;
		return result;
	}


	public static double round(double number, int afterSymbol) {
		double multiplier = (double) Math.pow(10, afterSymbol);
		int whole = (int) (number * multiplier);
		double result = (float) whole / multiplier;
		return result;
	}



}
