package com.dbs.lcsa.messagequeue.Model;

public class MessageDetails {
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }
    public int getqueueid() {
        return queueid;
    }

    public void setqueueid(int queueid) {
        this.queueid = queueid;
    }

    private int messageId;
    private String messageName;
    private int queueid;

    public MessageDetails(int queueid,int messageId, String messageName) {
        this.queueid=queueid;
        this.messageId = messageId;
        this.messageName = messageName;
    }
    public MessageDetails()
    {}
}
