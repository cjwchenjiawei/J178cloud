package com.cjw.webservice;

import javax.xml.ws.Endpoint;

public class WSMain {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        Endpoint.publish("http://127.0.0.1:8888/message",messageService);
    }
}
