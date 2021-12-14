package com.company;

public class Box {
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public void clear(){
        content = null;
    }

    public String toString() {
        return content.toString();
    }
}
