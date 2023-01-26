package org.weatherForcast;

public class NoAPIException extends RuntimeException  {
    public NoAPIException() {
        super();
    }
    public NoAPIException(String message) {
        super(message);
    }

}
