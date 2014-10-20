package com.bjut.sse.circle;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setOverflowShowingAlways();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_msg_center) {
			Toast.makeText(this, "跳转消息中心", Toast.LENGTH_LONG).show();
			return true;
		}
		if (id == R.id.action_post) {
			Toast.makeText(this, "跳转我的发布", Toast.LENGTH_LONG).show();
			return true;
		}
		if (id == R.id.action_top) {
			Toast.makeText(this, "跳转排行榜", Toast.LENGTH_LONG).show();
			return true;
		}
		if (id == R.id.action_settings) {
			Toast.makeText(this, "跳转设置页面", Toast.LENGTH_LONG).show();
			return true;
		}
		if (id == R.id.action_feed) {
			Toast.makeText(this, "跳转意见反馈", Toast.LENGTH_LONG).show();
			return true;
		}
		if (id == R.id.action_about) {
			Toast.makeText(this, "跳转关于", Toast.LENGTH_LONG).show();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		if(featureId == Window.FEATURE_ACTION_BAR && menu != null){
			if(menu.getClass().getSimpleName().equals("MenuBuilder")) {
				try {
					Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
				    m.setAccessible(true);
				    m.invoke(menu,true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}
	private void setOverflowShowingAlways() {  
        try {  
            ViewConfiguration config = ViewConfiguration.get(this);  
            Field menuKeyField = ViewConfiguration.class  
                    .getDeclaredField("sHasPermanentMenuKey");  
            menuKeyField.setAccessible(true);  
            menuKeyField.setBoolean(config, false);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
