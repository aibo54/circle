package com.bjut.sse.circle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class NewsContentActivity extends Activity{
	
	public static void actionStart(Context context, String newsContent){
		Intent intent = new Intent(context, NewsContentActivity.class);
		intent.putExtra("news_content",newsContent);
		context.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_content);
        
        String newsContent = getIntent().getStringExtra("news_content");
        
        NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager()
        		.findFragmentById(R.id.news_content_fragment);
		
        newsContentFragment.refresh(newsContent);
		
	}
}
