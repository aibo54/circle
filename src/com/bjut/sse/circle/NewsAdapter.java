package com.bjut.sse.circle;

import java.util.List;

import com.bjut.sse.circle.model.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<News> {
	private int resourceId;

	public NewsAdapter(Context context, int resource, List<News> objects) {
		super(context, resource, objects);
		resourceId =resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		News news = getItem(position);
		View view;
		ViewHolder viewHolder;
		//优化1:使用convertView
		//优化2：使用ViewHolder
		if(convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.newsImage = (ImageView) view.findViewById(R.id.news_image);
			viewHolder.newsContent = (TextView) view.findViewById(R.id.news_content_abstract);
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		
		viewHolder.newsImage.setImageResource(news.getImageId());
		viewHolder.newsContent.setText(news.getContent());
		return view;
	}
	
	class ViewHolder {
		ImageView newsImage;
		TextView newsContent;
	}

}
