package it.marcoberri.radiorisaiasud;

import it.marcoberri.radiorisaiasud.helper.MusicPlayer;
import it.marcoberri.radiorisaiasud.helper.Utils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;

public class MainActivity extends Activity  implements OnItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		MusicPlayer.pause();
	}

	@Override
	protected void onStop() {
		super.onStop();
		MusicPlayer.pause();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu_main_gallery:
			setContentView(R.layout.activity_gallery);
			Gallery g = (Gallery) findViewById(R.id.gallery);
	        g.setAdapter(new ImageAdapter(this));
	        g.setOnItemSelectedListener(this);			
			return true;
		case R.id.menu_main_website:
			Utils.launchWebBrowser("http://www.radiorisaiasud.it", this);
			return true;
		case R.id.menu_main_facebook:
			Utils.launchFacebookPage("Radio-Risaia-Sud/224882854223371",
					getPackageManager(), this);
			return true;
		case R.id.menu_main_email:
			return true;			
		case R.id.action_play:
			final boolean play = MusicPlayer.toggle(this, R.raw.mulitta_mulit);
			if (play) {
				item.setIcon(R.drawable.ic_pause);
			} else {
				item.setIcon(R.drawable.ic_play);
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
