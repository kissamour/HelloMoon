package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {

	private Button mPlayButton;
	private Button mStopButton;
	private Button mPauseButton;
	private AudioPlayer mPlayer = new AudioPlayer();

	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPlayer.play(getActivity());
				updatePlayButtons();
				mPauseButton.setEnabled(true);
			}
		});
		mStopButton = (Button) v.findViewById(R.id.hellomoon_stopButton);
		mStopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPlayer.stop();
				updatePlayButtons();
				mPauseButton.setEnabled(true);
			}
		});
		mPauseButton = (Button) v.findViewById(R.id.hellomoon_pauseButton);
		mPauseButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mPlayer.isPlaying()) {
					mPlayer.pause();
					mPlayButton.setEnabled(true);
					mPauseButton.setEnabled(false);

				}

			}
		});
		return v;
	}

	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}

	void updatePlayButtons() {
		boolean isEnabled = !mPlayer.isPlaying();
		mPlayButton.setEnabled(isEnabled);
	}

}
