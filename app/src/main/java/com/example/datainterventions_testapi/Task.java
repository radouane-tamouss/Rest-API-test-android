package com.example.datainterventions_testapi;

public class Task {
    private String request_id;

    private String requester_name;

    public Task(String request_id, String requester_name) {
        this.request_id = request_id;
        this.requester_name = requester_name;
    }

    public Task(String requester_name) {
        this.requester_name = requester_name;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getRequester_name() {
        return requester_name;
    }

    public void setRequester_name(String requester_name) {
        this.requester_name = requester_name;
    }
}
