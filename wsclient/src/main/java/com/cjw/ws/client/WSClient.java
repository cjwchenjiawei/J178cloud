package com.cjw.ws.client;

public class WSClient {
    public static void main(String[] argv) {
        MessageServiceService messageServiceService = new MessageServiceService();
        MessageService ms = messageServiceService.getMessageServicePort();
        String a = ms.message("a");
        System.out.println(a);
    }
}
