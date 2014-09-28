package info.androidhive.listviewfeed.adapter;


import java.util.ArrayList;

import com.android.volley.toolbox.ImageLoader;




import info.androidhive.listviewfeed.FeedImageView;
import info.androidhive.listviewfeed.MainActivity;
import info.androidhive.listviewfeed.PlayerViewDemoActivity;
import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.imageItem;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {
    int size;
    Activity act;
    View layout;
    FeedImageView imageview;
    Button click;
    ArrayList<imageItem> imagecluster = new ArrayList<imageItem>() ;
    boolean picture;
    ImageView playicon;
  
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public ViewPagerAdapter(Activity activity,  ArrayList<imageItem> imageclusterarra) {
        // TODO Auto-generated constructor stub
    	
    	imagecluster= imageclusterarra;
        act = activity;
        
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imagecluster.size();
    }

    @Override
    public Object instantiateItem(View container, final int position) {
        // TODO Auto-generated method stub
    	if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
        LayoutInflater inflater = (LayoutInflater) act
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = inflater.inflate(R.layout.pagerrow, null);
        imageview = (FeedImageView) layout.findViewById(R.id.pagenumber);
        playicon = (ImageView) layout.findViewById(R.id.playicon);
        int pagenumberTxt=position + 1;
        if(imagecluster.get(position).isIsvideo()){
        	playicon.setVisibility(View.VISIBLE);
        	imageview.setImageUrl("http://img.youtube.com/vi/"+imagecluster.get(position).getImageUrl()+"/maxresdefault.jpg",imageLoader);
        	imageview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intnt = new Intent(act,
							PlayerViewDemoActivity.class);
					intnt.putExtra("youtube_id",imagecluster.get(position).getImageUrl() );
					intnt.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					act.startActivity(intnt);
				}
			});
        }
        else{
        imageview.setImageUrl(imagecluster.get(position).getImageUrl(), imageLoader);
        }
        ((ViewPager) container).addView(layout, 0);
        return layout;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
    

    // }

}