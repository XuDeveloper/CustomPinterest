package com.example.main;

/**
 * 主Activity类，用于测试
 * @author Xu
 */
import com.example.custompinterest.R;
import com.example.model.ChildView;
import com.example.model.ViewControlManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	private ViewControlManager manager;
	private String[] imgPath = {
			"http://pic14.nipic.com/20110522/7411759_164157418126_2.jpg",
			"http://pic.nipic.com/2007-11-09/200711912230489_2.jpg",
			"http://pic1.ooopic.com/uploadfilepic/sheji/2010-01-13/OOOPIC_1982zpwang407_20100113f68118f451f282f4.jpg",
			"http://img0.imgtn.bdimg.com/it/u=645511307,1441870729&fm=21&gp=0.jpg" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// 创建自定义ChildView
		ChildView child1 = new ChildView();
		child1.setId(10);
		child1.setImage(R.drawable.ic_launcher);
		child1.setText("11111111");
		ChildView child2 = new ChildView();
		child2.setId(20);
		child2.setImage(R.drawable.ic_launcher);
		child2.setText("22222222");
		ChildView child3 = new ChildView();
		child3.setId(30);
		child3.setImage(R.drawable.ic_launcher);
		child3.setText("33333333");
		ChildView child4 = new ChildView();
		child4.setId(10);
		child4.setImage(R.drawable.ic_launcher, 10000, 322);
		child4.setText("44444444");
		ChildView child5 = new ChildView();
		child5.setId(20);
		child5.setImageUrl("assets://1.jpg", 294, 278);
		child5.setText("55555555");
		ChildView child6 = new ChildView();
		child6.setId(30);
		child6.setImageUrl("assets://3.jpg", 254, 178);
		child6.setText("66666666");
		ChildView child7 = new ChildView();
		child7.setId(10);
		child7.setImageUrl(imgPath[0], 94, 78);
		child7.setText("ASASASIJ");
		ChildView child8 = new ChildView();
		child8.setId(20);
		child8.setImageUrl(imgPath[1], 123, 555);
		child8.setText("你好好啊啊");
		ChildView child9 = new ChildView();
		child9.setId(30);
		child9.setImageUrl(imgPath[2], 100, 220);
		child9.setText("74358973249");
		ChildView child10 = new ChildView();
		child10.setId(30);
		child10.setImageUrl(imgPath[3], 30, 340);
		child10.setText("43290532705923");
		ChildView child11 = new ChildView();
		child11.setId(20);
		child11.setImageUrl(imgPath[1], 123, 555);
		child11.setText("你好好啊啊");
		ChildView child12 = new ChildView();
		child12.setId(30);
		child12.setImageUrl(imgPath[2], 250, 620);
		child12.setText("74358973249");
		ChildView child13 = new ChildView();
		child13.setId(30);
		child13.setImageUrl(imgPath[3], 30, 540);
		child13.setText("43290532705923");
		ChildView child14 = new ChildView();
		child14.setId(10);
		child14.setImageUrl(imgPath[0], 94, 98);
		child14.setText("ASASASIJ");
		ChildView child15 = new ChildView();
		child15.setId(20);
		child15.setImageUrl(imgPath[1], 223, 155);
		child15.setText("你好好啊啊");

		ScrollView scrollView = (ScrollView) findViewById(R.id.scrolllview);
		// 创建Manager
		manager = new ViewControlManager(MainActivity.this, scrollView);
		ChildView[] childViews = { child1, child2, child3, child4, child5,
				child6, child7, child8, child9, child10, child11, child12,
				child13, child14, child15 };
		manager.addView(childViews);
	}

}
