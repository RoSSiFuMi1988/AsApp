package store.active.asapp.ticketActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.dd.CircularProgressButton;

import store.active.asapp.R;
import store.active.asapp.contactActivity.ContactActivity;
import store.active.asapp.homeActivity.MainActivity;
import store.active.asapp.locationActivity.LocationActivity;
import store.active.asapp.models.FailureTicket;
import utility.UrlRedirect;

import static java.lang.Thread.sleep;

public class TicketActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_ticket_activity);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final String ADDRESS_TO_SEND_FAILURE_TICKET = getString(R.string.AddressMailForTicket);

        final EditText etId = (EditText) findViewById(R.id.editTextId);
        final EditText etMessage = (EditText) findViewById(R.id.editTextMessage);
        final Context context = this.getApplicationContext();
        final CharSequence text = "Ticket registrato nel sistema riceverai contatti appena il guasto sarà risolto!";
        final CharSequence err_text = "Il Ticket deve avere un messaggio di almeno 20 caratteri";

        final CircularProgressButton btnSend = (CircularProgressButton) findViewById(R.id.buttonSubmit);
        btnSend.setEnabled(false);
        btnSend.setProgress(0);

        etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateFields(etId,etMessage,btnSend);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //extract Text from the EditText
                String id = etId.getText().toString();
                String message = etMessage.getText().toString();
                //starting from text of the editText create the Failure Ticket object
                FailureTicket ft = new FailureTicket(id,message);
                //create ticketPresenter
                final TicketPresenter tp = new TicketPresenter(ft,ADDRESS_TO_SEND_FAILURE_TICKET,context);

                //Bundle for extras of the intent.
                Bundle bundle = tp.openFailureTicket().getExtras();

                if(message.length() > 20){
                    //Get Extra Value for sync email send with the UI
                    if((bundle.getBoolean("IS_SENDED"))){
                        Log.e("Ticket","Ticket Inviato");
                        //launch the activity created
                        startActivity(Intent.createChooser(tp.openFailureTicket(), "Apertura Ticket guasto..."));
                        //launch snackbar to view the error message
                        Snackbar.make(v, text, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        //Change button state to Send.
                        btnSend.setProgress(100);
                        //clear the fields filled by the user
                        tp.clearFields(etId,etMessage,btnSend);
                    }
                }

                else{
                    //launch snackbar to view the error message
                    Snackbar.make(v, err_text, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }

            }
        });

    }

    //Check if all EditText is filled with some text and activate Button.
    public void validateFields(EditText etId,EditText etMessage, CircularProgressButton btnSend){
        if ((etId.getText().length() > 0) && (etMessage.getText().length() > 0)){
            btnSend.setEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_ticket_activity);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //check if EditText is empty, return true if edit Text is empty.
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.send_email:
                Intent mailIntent = new Intent(this, ContactActivity.class);
                startActivity(mailIntent);
                break;
            case R.id.send_failure_ticket:
                Intent ticketIntent = new Intent(this, TicketActivity.class);
                startActivity(ticketIntent);
                break;
            case R.id.position:
                Intent positionIntent = new Intent(this, LocationActivity.class);
                startActivity(positionIntent);
                break;
            case R.id.author:
                UrlRedirect urlRed = new UrlRedirect(this.getApplicationContext(),getString(R.string.linkedinDeveloper));
                urlRed.redirect();
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_ticket_activity);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}