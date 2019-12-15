package com.sundarland.game.exceptions;

public class GameExceptionResponse {
    private String id;

    public GameExceptionResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
