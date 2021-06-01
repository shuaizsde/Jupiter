package com.laioffer.jupiter.external;

//We’ll throw this exception if there is something wrong when calling Twitch API.
//把所有twitch 导致的exception都装在这里面
public class TwitchException extends RuntimeException {
    public TwitchException(String errorMessage) {
        super(errorMessage);
    }
}

