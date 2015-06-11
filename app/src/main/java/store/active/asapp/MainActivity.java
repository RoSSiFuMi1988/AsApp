package store.active.asapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.MapFragment;

import Redirect.UrlRedirect;


public class MainActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private Toolbar mToolbar;
    public LocationFragment lf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
        // populate the navigation drawer
        mNavigationDrawerFragment.setUserData("ACTIVE STORE", "Computer | Telefonia | Sicurezza | Assistenza", BitmapFactory.decodeResource(getResources(), R.drawable.ic_logo));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        Fragment fragment=null;

        switch (position){
            case 0:
                fragment = new FirstPageFragment();
                //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                fragment = new ContactPageFragment();
                //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                fragment = new LocationFragment();

                //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Context context = this.getApplicationContext();
                UrlRedirect urlRed = new UrlRedirect(context);
                urlRed.redirect();
                //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
                break;

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
        // update the first_page_fragment content by replacing fragments
        //Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.ic_coding.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*private void addMapFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        fragment = new MapFragment();
        transaction.add(R.id.mapView, fragment);
        transaction.commit();
    }*/



}
