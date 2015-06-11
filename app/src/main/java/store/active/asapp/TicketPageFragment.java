package store.active.asapp;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by antonio on 11/06/15.
 */
public class TicketPageFragment extends Fragment{
    public TicketPageFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.open_ticket_fragment, container, false);

        final EditText etId = (EditText) rootView.findViewById(R.id.editTextId);
        final EditText etMessage = (EditText) rootView.findViewById(R.id.editTextMessage);
        final Context context = rootView.getContext();
        final CharSequence text = "Ticket registrato nel sistema riceverai contatti appena il guasto sarà risolto!";
        final int duration = Toast.LENGTH_SHORT;

        Button btnSend = (Button) rootView.findViewById(R.id.buttonSubmit);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //extract Text from the EditText
                String id = etId.getText().toString();
                String message = etMessage.getText().toString();


                /**@param email_address picked from strings.xml at voice AddressMailForTicket*/
                //make new Intent for sending Ticket use for address a string declared in strings.xml
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", getString(R.string.AddressMailForTicket), null));
                //adding subject to email
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ticket opening");
                //adding body of message to email
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);
                //launch the activity created
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

                //clear the fields filled by the user
                clearFields(etId,etMessage);

            }
        });
        return rootView;
    }

    public void clearFields(EditText et1, EditText et2){
        et1.setText("");
        et2.setText("");

    }

}
