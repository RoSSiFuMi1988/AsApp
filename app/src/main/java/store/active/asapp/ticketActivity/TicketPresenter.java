package store.active.asapp.ticketActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;

import store.active.asapp.models.FailureTicket;

public class TicketPresenter {
    Context context;
    String addressToSendTicket;
    FailureTicket failureTicket;

    public TicketPresenter(FailureTicket _failureTicket, String _addressToSendTicket, Context _context){
        this.context = _context;
        this.failureTicket = _failureTicket;
        this.addressToSendTicket = _addressToSendTicket;
    }

    public Intent openFailureTicket(){

        /**@param email_address picked from strings.xml at voice AddressMailForTicket*/
        //make new Intent for sending Ticket use for address a string declared in strings.xml
        Intent ticketIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", addressToSendTicket, null));
        //adding subject to email
        ticketIntent.putExtra(Intent.EXTRA_SUBJECT, "Ticket opening from " + failureTicket.getpIva());
        //adding body of message to email
        ticketIntent.putExtra(Intent.EXTRA_TEXT, failureTicket.getTicketRequest());

        return ticketIntent;
    }

    public void clearFields(EditText et1, EditText et2){
        et1.setText("");
        et2.setText("");

    }
}
