package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class AudioPlayer {
	private MediaPlayer mPlayer;
	public boolean isPause;
	
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
			isPause=false;
		}
	}

	public void play(Context c) {
		if (isPause) {
			mPlayer.start();
		} else {
			stop();
			mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

			mPlayer.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					// TODO Auto-generated method stub
					stop();
				}
			});
			mPlayer.start();
		}
	}

	public void pause() {
		mPlayer.pause();
		isPause = true;
	}



	public boolean isPlaying() {

		return mPlayer != null;

	}
}
