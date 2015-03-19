package com.gizwits.ledgateway.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.gizwits.framework.activity.BaseActivity;
import com.gizwits.ledgateway.R;
import com.gizwits.ledgateway.adapter.MListViewAdapter;

public class MainActivity extends BaseActivity implements OnClickListener {
	Button button1;
	Map<String, List<String>> mapList=new HashMap<String, List<String>>();
	List<String> ledList = new ArrayList<String>();
	List<String> list = new ArrayList<String>();
	MListViewAdapter mlistadapter;
	
	static String showString = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_device_list);
		ListView listview=(ListView) findViewById(R.id.listview);
		button1=(Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		mapList.put("我的LED", ledList);
		mapList.put("客厅组", new ArrayList<String>());
		mapList.put("主人卧室组", new ArrayList<String>());
		mapList.put("", new ArrayList<String>());
		list.add("我的LED");
		list.add("客厅组");
		list.add("主人卧室组");
		list.add("");
		mlistadapter=new MListViewAdapter(this, mapList, list);
		listview.setAdapter(mlistadapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "position "+position, Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ledList.add("111");
		mapList.remove("我的LED");
		mapList.put("我的LED", ledList);
		mlistadapter.notifyDataSetChanged();
	}
}
