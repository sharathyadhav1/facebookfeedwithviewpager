package info.androidhive.listviewfeed;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayer.Provider;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class youtubefragment extends Fragment {
	View youtubefragment; 
	String id;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		id = getArguments().getString("youtube_id");
		Log.i("calledir", id);
		
		youtubefragment = inflater.inflate(R.layout.youtubefragment, container, false);
		YouTubePlayerSupportFragment youTubeView = new YouTubePlayerSupportFragment();
		//YouTubePlayerView youTubeView = (YouTubePlayerView)youtubefragment.findViewById(R.id.youtube_view_inflated2);
	    youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, new OnInitializedListener() {
			
			@Override
			public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer player,
				      boolean wasRestored) {
				// TODO Auto-generated method stub
				if (!wasRestored) {
			    	if(id!=null){
			      player.cueVideo(id);
			    	}
				}
			}
			
			@Override
			public void onInitializationFailure(Provider arg0,
					YouTubeInitializationResult arg1) {
				// TODO Auto-generated method stub
				
			}
		});
	  
		
		return youtubefragment;
	}
	

}
