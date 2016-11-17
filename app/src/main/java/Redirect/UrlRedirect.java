package Redirect;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Classe utilizzata per il redirect verso una particolare pagina web, in questo caso profilo personale Linkedin
 * Created by antonio on 12/05/15.
 */
public class UrlRedirect {

    Context context;
    String URL_TO_REDIRECT;
    //url of the page to redirect
    //static String URL_TO_REDIRECT = new String ("https://it.linkedin.com/pub/antonio-francesco-iovine/39/aa8/823");

   public UrlRedirect(Context context,String url_to_redirect){
        this.context = context;
       this.URL_TO_REDIRECT = url_to_redirect;
    }

    /**
     * Metodo per il check della connessione internet sia via wifi che attraverso la rete dati
     */
    private boolean checkInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        if (cm.getActiveNetworkInfo() != null /*&& cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()*/) {
            return true;
        } else {
            return false;
        }
    }

    public void redirect(){

        //controlla la connessione a Internet se non è presente lancia un Toast di notifica per connessione assente
        //boolean check = checkInternetConnection();
        boolean check = true;//VALORE FALSATO DA AGGIUSTARE IL METODO CHECKINTERNETCONNECTION
        if(check != false) {
            //calling new intent
            Intent i = new Intent(Intent.ACTION_VIEW);
            //used for calling startActivity() outside from any activity
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setData(Uri.parse(URL_TO_REDIRECT));
            context.startActivity(i);
        }
        else {
            Toast toast = Toast.makeText(context, "Connessione Internet Disabilitata!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}
