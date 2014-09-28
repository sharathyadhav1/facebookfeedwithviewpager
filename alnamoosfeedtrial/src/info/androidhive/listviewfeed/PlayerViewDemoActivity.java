/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package info.androidhive.listviewfeed;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;








import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;

/**
 * A simple YouTube Android API demo application which shows how to create a simple application that
 * displays a YouTube Video in a {@link YouTubePlayerView}.
 * <p>
 * Note, to use a {@link YouTubePlayerView}, your activity must extend {@link YouTubeBaseActivity}.
 */
public class PlayerViewDemoActivity extends YouTubeFailureRecoveryActivity {

	String id;
	 boolean flag=true;
	 static final int REQUEST_SHARE = 1;
	 ImageButton shredetail,backbtn;
	 SharedPreferences prefs = null;
	 Calendar cal;
	 String youtube_id_passed;
	 View customView;
	 String formattedDate;

@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i("restored", "restored");
	}

@SuppressLint("NewApi")
@Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
 
    
  //  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    setContentView(R.layout.homevideo);
  id = getIntent().getStringExtra("youtube_id");
  Log.i("youtubeid", "a"+id);
  
  

    YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view_inflated);
   
    youTubeView.setBackgroundResource(R.drawable.blank);
    youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
    
    
//    shredetail = (ImageButton)customView.findViewById(R.id.sharebtn);
//    backbtn = (ImageButton)customView.findViewById(R.id.backbtn);
//   shredetail.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			if(flag){
//				shredetail.setEnabled(false);
//					flag= false;
//					Toast.makeText(v.getContext(),"Share",Toast.LENGTH_SHORT).show();
//
//					
//					   Intent share = new Intent(Intent.ACTION_SEND);
//				    share.setType("image/*");
//				 //   share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
//				    share.putExtra(Intent.EXTRA_TEXT,"http://www.youtube.com/watch?v="+id);
//				    startActivityForResult(Intent.createChooser(share, "Share Image"),REQUEST_SHARE);
//			
//		}
//	}
//		});
//   backbtn.setOnClickListener(new OnClickListener() {
//		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			PlayerViewDemoActivity.this.finish();
//			// overridePendingTransition  (R.anim.popslide_in_right, R.anim.popslide_out_left);
//		}
//	});
    
    
    
    
  }
//@Override
//protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//	Log.i("requestCode", "requestCode");
//    if (requestCode == REQUEST_SHARE) {
//    	Log.i("sad", "asdasd");
//    	shredetail.setEnabled(true);
//		flag = true;
//       
//    }
//}

  @Override
  public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer player,
      boolean wasRestored) {
    if (!wasRestored) {
    	if(id!=null){
      player.loadVideo(id);
    	}
    	else{
    		
    		// player.cueVideo(prefs.getString(""+cal.HOUR+":"+cal.MINUTE,""));
    		 player.loadVideo(prefs.getString(formattedDate,""));
    	}
    	//player.setPlayerStyle(arg0)
     // player.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
      //player.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
//      player.setOnFullscreenListener(new OnFullscreenListener() {
//		
//		@Override
//		public void onFullscreen(boolean isFullscreen) {
//			// TODO Auto-generated method stub
//			//isFullscreen = false;
//			if(isFullscreen){
//				Log.i("clicked", "clikced");
//				//player.setFullscreen(false);
//				
//				//finish();
//			}
//		}
//	});
      
      //player.play();
    }
  }

  @Override
  protected YouTubePlayer.Provider getYouTubePlayerProvider() {
    return (YouTubePlayerView) findViewById(R.id.youtube_view_inflated);
  }

@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	//finish();
}

@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	Log.i("back presssed", "pressed");
	finish();
}
  

}
