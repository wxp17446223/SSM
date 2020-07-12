package cn.com.bean;

public enum StatusEnum {
    UN_LINE("离线"),
    IN_LINE("在线");

    StatusEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    private  String text;

}
