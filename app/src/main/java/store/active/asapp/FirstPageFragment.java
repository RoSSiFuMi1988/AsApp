package store.active.asapp;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class FirstPageFragment extends Fragment {

	private String image1_url = "http://www.active-store.it/img/slider01.png";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


				View rootView = inflater.inflate(R.layout.first_page_fragment, container, false);
		ImageView imv0 = (ImageView) rootView.findViewById(R.id.imageView0);
		ImageView imv1 = (ImageView) rootView.findViewById(R.id.imageView1);
		ImageView imv2 = (ImageView) rootView.findViewById(R.id.imageView2);
		imv0.setImageResource(R.drawable.logo_completo);
		imv1.setImageResource(R.drawable.slider01);
		imv2.setImageResource(R.drawable.slider02);

		return rootView;
	}


}
