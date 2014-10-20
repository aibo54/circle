package com.bjut.sse.circle;

public interface HttpCallbackListener {
	void onFinish(String response);
	void onError(Exception e);
}
