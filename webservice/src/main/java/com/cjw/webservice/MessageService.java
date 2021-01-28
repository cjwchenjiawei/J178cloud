package com.cjw.webservice;

import javax.jws.WebService;

@WebService
public class MessageService {

    public String message(String tag){
        String str = "";
        switch (tag){
            case "a":
                str = "A";
                break;
        }
        return str;
    }
}
