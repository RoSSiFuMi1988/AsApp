package store.active.asapp.models;

public class NotificationMessage {
    String sender,body;

    public NotificationMessage(String _sender, String _body){

        this.sender = _sender;
        this.body = _body;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
