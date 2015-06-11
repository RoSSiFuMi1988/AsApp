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

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ContactPageFragment extends Fragment {

    String name,emailsender,object,message;


	public ContactPageFragment() {
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		final View rootView = inflater.inflate(R.layout.contact_fragment, container, false);

            final EditText etName = (EditText) rootView.findViewById(R.id.editTextName);
            final EditText etMailResponse = (EditText) rootView.findViewById(R.id.editTextMail);
            final EditText etObject = (EditText) rootView.findViewById(R.id.editTextSubject);
            final EditText etMessage = (EditText) rootView.findViewById(R.id.editTextMessage);
            final Context context = rootView.getContext();
            final CharSequence text = "Email inviata riceverai una risposta il prima possibile!";
            final int duration = Toast.LENGTH_SHORT;

            Button btnSend = (Button) rootView.findViewById(R.id.buttonSubmit);

            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //extract Text from the EditText
                    String name = etName.getText().toString();
                    String mailaddress = etMailResponse.getText().toString();
                    String object = etObject.getText().toString();
                    String message = etMessage.getText().toString();


                    /*Setting the email to send message to the address in this string picked from
                    * /values/strings.xml
                    * */
                    //String email_address = getString(R.string.AddressOfMailToSend);


                    /**@param email_address picked from strings.xml at voice AddressOfMailToSend*/
                    //make new Intent for sending email
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", getString(R.string.AddressOfMailToSend), null));
                    //adding subject to email
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, object);
                    //adding body of message to email
                    emailIntent.putExtra(Intent.EXTRA_TEXT, message);
                    //launch the activity created
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    //create toast to advise sending email.
                    //Toast toast = Toast.makeText(context, text, duration);
                    //toast.show();

                    //clear the fields filled by the user
                    clearFields(etName,etMailResponse,etObject,etMessage);

                }
            });
		return rootView;
	}

    public void clearFields(EditText et1, EditText et2, EditText et3, EditText et4){
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
    }

}
