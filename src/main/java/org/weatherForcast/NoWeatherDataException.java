package org.weatherForcast;

public class NoWeatherDataException  extends RuntimeException{
    public NoWeatherDataException() {
        super();
    }
    public NoWeatherDataException(String message) {
        super(message);
    }
}
