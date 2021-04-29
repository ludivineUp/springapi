package com.example.entities;

public class Message {

    private String msg; // null par défaut
    private int repeat; // 0 par defaut

    public Message() {
        this.msg = "";
    }

    public Message(String msg, int repeat) {
        this.msg = msg;
        this.repeat = repeat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }
}
