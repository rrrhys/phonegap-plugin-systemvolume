package com.jiliac.systemvolume;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;

public class SystemVolume extends CordovaPlugin {
	public SystemVolume(){

	}

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.equals("setSystemVolume")) {
			this.setSystemVolume(args.getDouble(0));
		} else if (action.equals("getAudioVolume")) {
		    this.getSystemVolume();
		    String message = "Success Audio Volume Get";
		    callbackContext.success(message);
		    return true;
		} else {
			return false;
		}

		callbackContext.success();
		return true;
	}
	
	    public int getSystemVolume() {
		AudioManager am = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
		try {
			int Level;
			int max = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
			int current =am.getStreamVolume(AudioManager.STREAM_MUSIC);
			Level = Math.round(current / max);
			return Level;
		}catch (Exception e) {
			return 1; 
		}
	    }

	public void setSystemVolume(double volume) {
		AudioManager am = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
		
		am.setStreamVolume(
			AudioManager.STREAM_MUSIC,
			(int) (am.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * volume),
			0);
		/*am.setStreamVolume(
			AudioManager.STREAM_SYSTEM,
			(int) (am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM) * volume),
			0);
			*/
	}
}
