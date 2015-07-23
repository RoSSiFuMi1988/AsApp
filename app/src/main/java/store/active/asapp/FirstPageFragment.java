package store.active.asapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ViewSwitcher;

public class FirstPageFragment extends Fragment {

	//private String image1_url = "http://www.active-store.it/img/slider01.png";
	ImageSwitcher imageSwitcher;
	//array of image resources for the ImageSwitcher
	int imageResources[] = {
			R.drawable.slider01,R.drawable.slider02,
	};
	Animation slide_in_left, slide_out_right;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


		final View rootView = inflater.inflate(R.layout.first_page_fragment, container, false);
		//header with logo of Company
		ImageView imv0 = (ImageView) rootView.findViewById(R.id.imageView0);
		imv0.setImageResource(R.drawable.logo_completo);

		//setting behavior of ImageSwither to change image
		slide_in_left = AnimationUtils.loadAnimation(this.getActivity(), android.R.anim.slide_in_left);
		slide_out_right = AnimationUtils.loadAnimation(this.getActivity(), android.R.anim.slide_out_right);
		imageSwitcher = (ImageSwitcher) rootView.findViewById(R.id.imageSwitcher);

		//inizialize the ImageSwitcher
		imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

			@Override
			public View makeView() {

				ImageView imageView = new ImageView(getActivity());
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

				FrameLayout.LayoutParams params = new ImageSwitcher.LayoutParams(
						RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.MATCH_PARENT);

				imageView.setLayoutParams(params);
				return imageView;

			}
		});

		//set Animation for imageSwitcher
		imageSwitcher.setInAnimation(slide_in_left);
		imageSwitcher.setOutAnimation(slide_out_right);
		//set first image of the Image Switcher
		imageSwitcher.setImageResource(R.drawable.slider02);

		//method for automatic switch of the image into the ImageSwitcher after delay
		imageSwitcher.postDelayed(new Runnable() {
			int i = 0;
			public void run() {
				imageSwitcher.setImageResource(i++ % 2 == 0 ? R.drawable.slider01 : R.drawable.slider02);
				imageSwitcher.postDelayed(this, 5000);
			}}, 5000);

		return rootView;
	}


}
