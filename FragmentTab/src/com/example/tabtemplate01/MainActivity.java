package com.example.tabtemplate01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private LinearLayout tab01;
	private LinearLayout tab02;
	private LinearLayout tab03;
	private LinearLayout tab04;

	private ImageView imgMessage;
	private ImageView imgFriend;
	private ImageView imgContact;
	private ImageView imgSetting;

	private Fragment message;
	private Fragment friend;
	private Fragment contact;
	private Fragment setting;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		setListener();
		setSelected(0);
	}

	private void setSelected(int i) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);

		switch (i) {
		case 0:
			if(message==null){
				message = new MessageFragment();
				transaction.add(R.id.id_content, message);
			}else{
				transaction.show(message);
			}
			imgMessage.setImageResource(R.drawable.tab_messages_pressed);
			break;
		case 1:
			if(friend==null){
				friend = new FriendFragment();
				transaction.add(R.id.id_content, friend);
			}else{
				transaction.show(friend);
			}
			imgFriend.setImageResource(R.drawable.tab_friends_pressed);
			break;
		case 2:
			if(contact==null){
				contact = new ContactFragment();
				transaction.add(R.id.id_content, contact);
			}else{
				transaction.show(contact);
			}
			imgContact.setImageResource(R.drawable.tab_contact_pressed);
			break;
		case 3:
			if(setting==null){
				setting = new SettingFragment();
				transaction.add(R.id.id_content, setting);
			}else{
				transaction.show(setting);
			}
			imgSetting.setImageResource(R.drawable.tab_settings_pressed);
			break;
		}
		
		transaction.commit();
	}



	private void hideFragment(FragmentTransaction transaction) {
		if(message!=null){
			transaction.hide(message);
		}
		if(friend!=null){
			transaction.hide(friend);
		}
		if(contact!=null){
			transaction.hide(contact);
		}
		if(setting!=null){
			transaction.hide(setting);
		}
	}

	private void setListener() {
		tab01.setOnClickListener(this);
		tab02.setOnClickListener(this);
		tab03.setOnClickListener(this);
		tab04.setOnClickListener(this);
	}

	private void initView() {
		tab01 = (LinearLayout) findViewById(R.id.id_tab01);
		tab02 = (LinearLayout) findViewById(R.id.id_tab02);
		tab03 = (LinearLayout) findViewById(R.id.id_tab03);
		tab04 = (LinearLayout) findViewById(R.id.id_tab04);

		imgMessage = (ImageView) findViewById(R.id.img_tab01);
		imgFriend = (ImageView) findViewById(R.id.img_tab02);
		imgContact = (ImageView) findViewById(R.id.img_tab03);
		imgSetting = (ImageView) findViewById(R.id.img_tab04);

	}

	@Override
	public void onClick(View v) {
		resetImgs();

		switch (v.getId()) {
		case R.id.id_tab01:
			setSelected(0);
			break;

		case R.id.id_tab02:
			setSelected(1);
			break;
		case R.id.id_tab03:
			setSelected(2);
			break;
		case R.id.id_tab04:
			setSelected(3);
			break;
		}
	}

	private void resetImgs() {
		imgMessage.setImageResource(R.drawable.tab_messages_normal);
		imgFriend.setImageResource(R.drawable.tab_friends_normal);
		imgContact.setImageResource(R.drawable.tab_contact_normal);
		imgSetting.setImageResource(R.drawable.tab_settings_normal);
	}
}
