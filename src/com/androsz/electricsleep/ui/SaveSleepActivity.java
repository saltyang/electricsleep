package com.androsz.electricsleep.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.androsz.electricsleep.R;

public class SaveSleepActivity extends CustomTitlebarActivity {

	public static final String SAVE_SLEEP = "com.androsz.electricsleep.SAVE_SLEEP";

	@Override
	protected int getContentAreaLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.activity_save;
	}

	@Override
	// @SuppressWarnings("unchecked")
	protected void onCreate(final Bundle savedInstanceState) {

		// registerReceiver(saveSleepReceiver, new IntentFilter(SAVE_SLEEP));
		super.onCreate(savedInstanceState);

		new AlertDialog.Builder(this)
				.setMessage("Do you wish to save this sleep history?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(final DialogInterface dialog,
									final int id) {
								final Intent saveIntent = new Intent(
										SaveSleepActivity.SAVE_SLEEP);
								saveIntent.putExtras(getIntent().getExtras());
								sendBroadcast(saveIntent);
								finish();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(final DialogInterface dialog,
							final int id) {
						// final Intent intent = new
						// Intent(SaveSleepActivity.this, HomeActivity.class);
						// startActivity(intent);
						finish();
						return;
					}
				}).show();
	}
}