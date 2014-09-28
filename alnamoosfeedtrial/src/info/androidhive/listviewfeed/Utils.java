package info.androidhive.listviewfeed;

import java.text.SimpleDateFormat;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Utils {

	public static String TAG = "UAE1971";
	public static final String PREFS_NAME = "UAE1971";
    public static String SENDER_ID = "903258465208"; 
    
    public static Typeface getnormalTypeFace(Context ctx){
    	Typeface type = Typeface.createFromAsset(ctx.getAssets(),
				"fonts/HelveticaNeueLTArabic-Light.ttf");
		return type;
    	
    }
    public static Typeface getBoldTypeFace(Context ctx){
    	Typeface type = Typeface.createFromAsset(ctx.getAssets(),
				"fonts/CPDFontAM.otf");
		return type;
    	
    }
   
    public static Typeface getTypeFace(Context ctx){
    	Typeface type = Typeface.createFromAsset(ctx.getAssets(),
				"fonts/HelveticaNeueLTArabic-Bold.ttf");
		return type;
    	
    }
    
   
    
    public static String getDensityName(Context context) {
	    float density = context.getResources().getDisplayMetrics().density;
	    if (density >= 4.0) {
	        return "xxxhdpi";
	    }
	    if (density >= 3.0) {
	        return "xxhdpi";
	    }
	    if (density >= 2.0) {
	        return "xhdpi";
	    }
	    if (density >= 1.5) {
	        return "hdpi";
	    }
	    if (density >= 1.0) {
	        return "mdpi";
	    }
	    return "ldpi";
	}
    public static String getformattime(String string){
    	String s2="";
    	try{
    		
			
			java.util.Date d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(string);
			 s2 = (new SimpleDateFormat("dd-MMMM-yyyy")).format(d);
			
			} catch(Exception e) {
			e.printStackTrace();
			}
		
		return s2;
    	
    }
}
