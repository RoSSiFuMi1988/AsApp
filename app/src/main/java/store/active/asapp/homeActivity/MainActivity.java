package store.active.asapp.homeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import java.util.HashMap;
import store.active.asapp.R;
import store.active.asapp.contactActivity.ContactActivity;
import store.active.asapp.ticketActivity.TicketActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SliderLayout mSliderLayout;
    MainPresenter mPresenter = new MainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_main_activity);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mSliderLayout = (SliderLayout) findViewById(R.id.slider_home);

        FloatingActionButton fab_call = (FloatingActionButton) findViewById(R.id.fab_call);
        fab_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Effettuo Chiamata all'ufficio", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                String phone = getString(R.string.office_phone);
                startActivity(mPresenter.makeCall(phone));
            }
        });

        FloatingActionButton fab_facebook = (FloatingActionButton) findViewById(R.id.fab_facebook);
        fab_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Apro Profilo Facebook", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                String facebook = getString(R.string.facebook_account);
               startActivity(mPresenter.openSocial(facebook));
            }
        });

        FloatingActionButton fab_twitter = (FloatingActionButton) findViewById(R.id.fab_twitter);
        fab_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Apro Profilo Twitter", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                String twitter = getString(R.string.twitter_account);
                startActivity(mPresenter.openSocial(twitter));
            }
        });

        //Set SliderLayout to show the image in drawable folder
        prepareSliderLayout(mPresenter.getListImageFromResource());

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_main_activity);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

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
                break;
            case R.id.author:
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_main_activity);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Method for prepare image to show into sliderLayout loaded from url of QrCode
    public void prepareSliderLayout(HashMap<String,Integer> file_maps){

        for(String name : file_maps.keySet()){
            TextSliderView mTextSliderView = new TextSliderView(this);
            mTextSliderView
                    .description(name)
                    .image(file_maps.get(name));

            mSliderLayout.addSlider(mTextSliderView);
        }
    }
}
