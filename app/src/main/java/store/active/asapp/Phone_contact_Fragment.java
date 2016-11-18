package store.active.asapp;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by antonio on 18/06/15.
 */
public class Phone_contact_Fragment extends Fragment {

    private String facebookAccount = new String("https://www.facebook.com/activestoreonline");
    private String twitterAccount = new String("https://twitter.com/activestore");
    private String officeNumber = "0823711976";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.phone_contact_fragment, container, false);


        //ImageView imv0 = (ImageView) rootView.findViewById(R.id.headerPhoneContactImageView);
        //imv0.setImageResource(R.drawable.logo_completo);

        ImageButton phoneButton = (ImageButton) rootView.findViewById(R.id.phoneButton);
        //setting image for the button
        phoneButton.setImageResource(R.drawable.phone_button);
        //setting background color to TRANSPARENT
        phoneButton.setBackgroundColor(Color.TRANSPARENT);

        ImageButton facebookButton = (ImageButton) rootView.findViewById(R.id.facebookButton);
        //setting image for the button
        facebookButton.setImageResource(R.drawable.ic_facebook_fab_button);
        //setting background color to TRANSPARENT
        facebookButton.setBackgroundColor(Color.TRANSPARENT);

        ImageButton twitterButton = (ImageButton) rootView.findViewById(R.id.twitterButton);
        //setting image for the button
        twitterButton.setImageResource(R.drawable.ic_twitter_fab_button);
        //setting background color to TRANSPARENT
        twitterButton.setBackgroundColor(Color.TRANSPARENT);

        //on button click the app redirect to facebook page
        facebookButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent open = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookAccount));
                startActivity(open);
            }
        });

        //on button click the app redirect to twitter page
        twitterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent open = new Intent(Intent.ACTION_VIEW, Uri.parse(twitterAccount));
                startActivity(open);
            }
        });

        //on button click the app make a call to the office
        phoneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + officeNumber));
                startActivity(intent);
            }
        });

        return rootView;




}}
