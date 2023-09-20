package com.mci.learning.controller;

public enum API {
    GET_ALL,
    GET,
    CREATE,
    UPDATE,
    DELETE;
    private final String api = "localhost:8080/api/student/";

    public String string(int id) {
        switch (this) {
            case GET_ALL:
                return api;
            case GET:
                return api + id;
            case CREATE:
                return api + "create";
            case UPDATE:
                return api + "update/" + id;
            case DELETE:
                return api + "delete/" + id;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
