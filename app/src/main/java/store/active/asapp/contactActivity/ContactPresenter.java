package store.active.asapp.contactActivity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;

import com.dd.CircularProgressButton;

import store.active.asapp.R;
import store.active.asapp.models.Mail;

public class ContactPresenter {
    Mail mailToSend;
    Context context;
    String sendingAddress;

    public ContactPresenter(Mail _mailToSend, Context _context,String _sendingAddress){
        this.mailToSend = _mailToSend;
        this.context = _context;
        this.sendingAddress = _sendingAddress;
    }

    public Intent sendMail(){
        /**@param email_address picked from strings.xml at voice AddressOfMailToSend*/
        //make new Intent for sending email use for address a string declared in strings.xml
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", sendingAddress, null));
        //adding subject to email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mailToSend.getObject());
        //adding body of message to email
        emailIntent.putExtra(Intent.EXTRA_TEXT, mailToSend.getBody_message());

        emailIntent.putExtra("IS_SENDED",true);

        return emailIntent;
    }

    public void clearFields(EditText et1, EditText et2, EditText et3, EditText et4, CircularProgressButton btnSend){
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        btnSend.setProgress(0);
        btnSend.setEnabled(false);
    }
}
