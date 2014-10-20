package com.bjut.sse.circle;

import java.util.ArrayList;
import java.util.List;

import com.bjut.sse.circle.model.News;
import com.bjut.sse.circle.utils.HttpUtil;
import com.bjut.sse.circle.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class NewsListFragment extends Fragment implements OnItemClickListener{
	private ListView newsTitlelistView;
	private List<News> newsList = new ArrayList<News>();
	private NewsAdapter adapter;
	
	private boolean isTwoPane;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		//newsList = getNews();
		
		queryNewsList();
		adapter = new NewsAdapter(activity, R.layout.news_item, newsList);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.news_title_frag, container, false);
		newsTitlelistView = (ListView) view.findViewById(R.id.news_title_list_view);
		newsTitlelistView.setAdapter(adapter);
		
		newsTitlelistView.setOnItemClickListener(this);
		
		
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
		super.onActivityCreated(savedInstanceState);
		if(getActivity().findViewById(R.id.news_content_layout) != null) {
			isTwoPane = true;
		}else{
			isTwoPane = false;
		}
		
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		News news = newsList.get(position);
		if(isTwoPane) {
			NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
					.findFragmentById(R.id.news_content_fragment);
			newsContentFragment.refresh(news.getContent());
		}else{
			NewsContentActivity.actionStart(getActivity(), news.getContent());
		}
		
	}
	
	private List<News> getNews(){
		List<News> newsList = new ArrayList<News>();
		
		News news1 = new News();
		news1.setContent("iPhone6���й�����Ԥ����!�����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ��");
		news1.setImageId(R.drawable.news_image_01);
		
		
		newsList.add(news1);
		News news2 = new News();
		news2.setContent("�µ�iPad Air���й�11�·�����!�����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ��");
		news2.setImageId(R.drawable.news_image_02);
		
		newsList.add(news2);
		News news3 = new News();
		news3.setContent("APEC�ھ��ٿ������ǿ��Էż���.�����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ�ڱ����Ұ����а�װ��");
		news3.setImageId(R.drawable.news_image_03);
		newsList.add(news3);
		return newsList;
	}

	
	private void queryNewsList() {
		queryFromServer();
	}
	private void queryFromServer() {
		String address = "http://172.18.3.190:8081/smtest/get_data.json";
		
		HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
			
			@Override
			public void onFinish(String response) {
				// TODO Auto-generated method stub
				LogUtil.i("Roger", response);
				
			}
			
			@Override
			public void onError(Exception e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void parseJSONWithGSON(String jsonData) {
		Gson gson = new Gson();
		newsList = gson.fromJson(jsonData, new TypeToken<List<News>>(){}.getType());
	}
}
