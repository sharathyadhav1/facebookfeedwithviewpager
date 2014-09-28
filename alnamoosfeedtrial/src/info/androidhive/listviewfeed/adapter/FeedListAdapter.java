package info.androidhive.listviewfeed.adapter;

import info.androidhive.listviewfeed.DeveloperKey;
import info.androidhive.listviewfeed.FeedImageView;
import info.androidhive.listviewfeed.MainActivity;
import info.androidhive.listviewfeed.PlayerViewDemoActivity;
import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.Utils;
import info.androidhive.listviewfeed.YouTubeFailureRecoveryActivity;
import info.androidhive.listviewfeed.youtubefragment;
import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.FeedItem;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;




public class FeedListAdapter extends BaseAdapter {	
	private FragmentActivity activity;
	private LayoutInflater inflater;
	private List<FeedItem> feedItems;
	Context context;
	private YouTubeFailureRecoveryActivity listener;
	boolean video =true;
	
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public FeedListAdapter(MainActivity activity, List<FeedItem> feedItems) {
		this.activity = activity;
		this.feedItems = feedItems;
		this.context=activity;
		//this.listener=listeners;
	}

	@Override
	public int getCount() {
		return feedItems.size();
	}

	@Override
	public Object getItem(int location) {
		return feedItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null){
			convertView = inflater.inflate(R.layout.itemfeed, null);
		}
		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();

		TextView name = (TextView) convertView.findViewById(R.id.name);
		
		TextView timestamp = (TextView) convertView
				.findViewById(R.id.timestamp);
		TextView statusMsg = (TextView) convertView
				.findViewById(R.id.txtStatusMsg);
		//name.setTypeface(Utils.getBoldTypeFace(context));
		//statusMsg.setTypeface(Utils.getBoldTypeFace(context));
		//TextView url = (TextView) convertView.findViewById(R.id.txtUrl);
//		NetworkImageView profilePic = (NetworkImageView) convertView
//				.findViewById(R.id.profilePic);
		ViewPager feedImageView = (ViewPager) convertView
				.findViewById(R.id.feedImage1);
		//FeedImageView youTubeView = (FeedImageView) convertView.findViewById(R.id.youtube_view_inflated);
		

	final FeedItem item = feedItems.get(position);
		//youTubeView.setVisibility(View.GONE);
	
		//String videourl = item.getVideourl();
		name.setText(item.getName());

		// Converting timestamp into x ago format
		CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
				Long.parseLong(item.getTimeStamp()),
				System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
		timestamp.setText(timeAgo);

		// Chcek for empty status message
		if (!TextUtils.isEmpty(item.getStatus())) {
			statusMsg.setText(item.getStatus());
			statusMsg.setVisibility(View.VISIBLE);
		} else {
			// status is empty, remove from view
			statusMsg.setVisibility(View.GONE);
		}

		// Checking for null feed url
//		if (item.getUrl() != null) {
//			url.setText(Html.fromHtml("<a href=\"" + item.getUrl() + "\">"
//					+ item.getUrl() + "</a> "));
//
//			// Making url clickable
//			url.setMovementMethod(LinkMovementMethod.getInstance());
//			url.setVisibility(View.VISIBLE);
//		} else {
//			// url is null, remove from the view
//			url.setVisibility(View.GONE);
//		}

		// user profile pic
		//profilePic.setImageUrl(item.getProfilePic(), imageLoader);

		// Feed image
		if (item.getImageArray().size()>0) {
			feedImageView.setVisibility(View.VISIBLE);
//			feedImageView.setImageUrl(item.getImge(), imageLoader);
//			feedImageView.setVisibility(View.VISIBLE);
//			feedImageView
//					.setResponseObserver(new FeedImageView.ResponseObserver() {
//						@Override
//						public void onError() {
//						}
//
//						@Override
//						public void onSuccess() {
//						}
//					});
			
//			for(int i =0;i<item.getImageArray().size();i++){
//			Log.e("item.....",item.getImageArray().get(i).getImagename());
//			}
			
			 ViewPagerAdapter adapter = new ViewPagerAdapter(activity, item.getImageArray());
			 feedImageView.setAdapter(adapter);
			 
			
		} 
		else {
			
//			 ViewPagerAdapter adapter = new ViewPagerAdapter(activity, item.getImageArray());
//			 feedImageView.setAdapter(adapter);
		
			
			
//			feedImageView.setVisibility(View.GONE);
//			youTubeView.setVisibility(View.VISIBLE);
//			Log.e("checkfor video", ""+item.getVideourl());
//			youTubeView.setImageUrl("http://img.youtube.com/vi/"+item.getVideourl()+"/maxresdefault.jpg",imageLoader);
//			
//			youTubeView.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					// TODO Auto-generated method stub
//					Log.i("item.getVideourl()", ""+item.getVideourl());
//					Log.i("checkfor video", "video");
//					Intent intnt = new Intent(activity,
//							PlayerViewDemoActivity.class);
//					intnt.putExtra("youtube_id",item.getVideourl() );
//					intnt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//					activity.startActivity(intnt);
//				}
//			});
		}
//		else {
//			feedImageView.setVisibility(View.GONE);
//			youTubeView.setVisibility(View.GONE);
//		}
		
		
		

		return convertView;
	}

}
