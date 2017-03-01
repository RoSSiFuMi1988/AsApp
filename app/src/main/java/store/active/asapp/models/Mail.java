package store.active.asapp.models;

public class Mail {

    String nameOfSender,mailToRespond,object,body_message;

    public Mail(String _nameOfSender, String _mailToRespond, String _object, String _body_message){
        this.nameOfSender = _nameOfSender;
        this.mailToRespond = _mailToRespond;
        this.object = _object;
        this.body_message = _body_message;
    }

    public String getNameOfSender() {
        return nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender = nameOfSender;
    }

    public String getMailToRespond() {
        return mailToRespond;
    }

    public void setMailToRespond(String mailToRespond) {
        this.mailToRespond = mailToRespond;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getBody_message() {
        return body_message;
    }

    public void setBody_message(String body_message) {
        this.body_message = body_message;
    }
}
