package store.active.asapp.homeActivity;

import android.content.Intent;
import android.net.Uri;

import java.util.HashMap;

import store.active.asapp.R;

public class MainPresenter {

    //Pick resources from drawable folder and create HashMap for method in Activity
    public HashMap<String,Integer> getListImageFromResource(){

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Rimetti in forma il tuo computer", R.drawable.slider01);
        file_maps.put("Smartphone rotto?", R.drawable.slider02);

        return file_maps;
    }

    public Intent openSocial(String socialUrl){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(socialUrl));
        return intent;
    }

    public Intent makeCall(String phoneToCall){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneToCall));
        return intent;
    }
}
