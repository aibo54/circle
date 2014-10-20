package com.bjut.sse.circle;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

public class PlusActionProvider extends ActionProvider{
    private Context context;
	
	public PlusActionProvider(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onPrepareSubMenu(SubMenu subMenu) {
		subMenu.clear();
		subMenu.add(context.getString(R.string.plus_group_chat))
		.setIcon(R.drawable.ofm_group_chat_icon)
		.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(context, "��ת������Ⱥ�ĵĽ���", Toast.LENGTH_LONG).show();
				return false;
			}
		});
		subMenu.add(context.getString(R.string.plus_add_friend))
		.setIcon(R.drawable.ofm_add_icon)
		.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(context, "��ת����Ӻ��ѵĽ���", Toast.LENGTH_LONG).show();
				return false;
			}
		});
		subMenu.add(context.getString(R.string.plus_video_chat))
		.setIcon(R.drawable.ofm_video_icon)
		.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(context, "��ת����Ƶ����Ľ���", Toast.LENGTH_LONG).show();
				return false;
			}
		});
		subMenu.add(context.getString(R.string.plus_scan))
		.setIcon(R.drawable.ofm_qrcode_icon)
		.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(context, "��ת��ɨһɨ�Ľ���", Toast.LENGTH_LONG).show();
				return false;
			}
		});
		subMenu.add(context.getString(R.string.plus_take_photo))
		.setIcon(R.drawable.ofm_camera_icon)
		.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(context, "��ת�����շ������", Toast.LENGTH_LONG).show();
				return false;
			}
		});
		
		
		
		super.onPrepareSubMenu(subMenu);
	}
	
	@Override
	public boolean hasSubMenu() {
		return true;
	}

}
