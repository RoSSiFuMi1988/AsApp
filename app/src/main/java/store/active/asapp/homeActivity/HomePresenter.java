package store.active.asapp.homeActivity;

import java.util.HashMap;

import store.active.asapp.R;

public class HomePresenter {

    //Pick resources from drawable folder and create HashMap for method in Activity
    public HashMap<String,Integer> getListImageFromResource(){

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Rimetti in forma il tuo computer", R.drawable.slider01);
        file_maps.put("Smartphone rotto?", R.drawable.slider02);

        return file_maps;
    }
}
