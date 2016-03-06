package com.example.model;

/**
 * ViewControlManager类，用于管理相关的ChildView资源
 * @author Xu
 */
import com.example.custompinterest.R;
import com.example.data.Const;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageSize;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class ViewControlManager {

	private LinearLayout leftLayout;
	private LinearLayout middleLayout;
	private LinearLayout rightLayout;
	private ImageView imageView;
	private TextView textView;
	private ScrollView view;
	private Context context;
	private ImageLoader imageLoader;
	private ImageLoaderConfiguration configuration;
	private View itemView;
	private int maxWidth;
	private int maxHeight;

	public ViewControlManager(Context context, ScrollView container) {
		this.context = context;
		view = container;
		maxWidth = getScreenWidth();
		maxHeight = getScreenHeight();

		leftLayout = (LinearLayout) view.findViewById(R.id.layout1);
		middleLayout = (LinearLayout) view.findViewById(R.id.layout2);
		rightLayout = (LinearLayout) view.findViewById(R.id.layout3);
	}

	public void addView(final ChildView child) {
		itemView = LayoutInflater.from(context).inflate(R.layout.item, null);
		imageView = (ImageView) itemView.findViewById(R.id.image);
		textView = (TextView) itemView.findViewById(R.id.text);
		// 采用开源库universal-image-loader加载图片
		setImageLoader();
		textView.setText(child.getText());
		// 通过id决定摆放的位置
		if (child.getId() % 3 == 1) {
			addViewInLeft(child);
		} else if (child.getId() % 3 == 2) {
			addViewInMiddle(child);
		} else {
			addViewInRight(child);
		}
	}

	public void addView(final ChildView[] child) {
		for (int i = 0; i < child.length; i++) {
			addView(child[i]);
		}
	}

	private int getScreenWidth() {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(metrics);
		return metrics.widthPixels;
	}

	private int getScreenHeight() {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(metrics);
		return metrics.heightPixels;
	}

	private void setImageLoader() {
		imageLoader = ImageLoader.getInstance();
		configuration = ImageLoaderConfiguration.createDefault(context);
		imageLoader.init(configuration);
	}

	private void addViewInLeft(final ChildView child) {
		if (child.getImage() != 0) {
			imageView.setBackgroundResource(child.getImage());
			if (child.getImageWidth() != 0 && child.getImageHeight() != 0) {
				if (child.getImageWidth() <= maxWidth * Const.LEFT_WEIGHT) {
					LayoutParams params = new LayoutParams(
							child.getImageWidth(), child.getImageHeight());
					imageView.setLayoutParams(params);
				}
			} else {
				LayoutParams params = new LayoutParams(
						LayoutParams.MATCH_PARENT, maxHeight * 1
								/ Const.COUNT_HEIGHT);
				imageView.setLayoutParams(params);
			}

		} else if (child.getImageUrl() != null) {
			if (child.getImageWidth() != 0 && child.getImageHeight() != 0) {
				if (child.getImageWidth() <= maxWidth * Const.LEFT_WEIGHT) {
					ImageSize imageSize = new ImageSize(child.getImageWidth(),
							child.getImageHeight());
					imageLoader.displayImage(child.getImageUrl(), imageView,
							imageSize);
				} else {
					ImageSize imageSize = new ImageSize(maxWidth,
							child.getImageHeight());
					imageLoader.displayImage(child.getImageUrl(), imageView,
							imageSize);
				}
			} else {
				imageLoader.displayImage(child.getImageUrl(), imageView);
			}
		}
		leftLayout.addView(itemView);
	}

	private void addViewInMiddle(final ChildView child) {
		if (child.getImage() != 0) {
			imageView.setBackgroundResource(child.getImage());
			if (child.getImageWidth() != 0 && child.getImageHeight() != 0) {
				if (child.getImageWidth() <= maxWidth * Const.MIDDLE_WEIGHT) {
					LayoutParams params = new LayoutParams(
							child.getImageWidth(), child.getImageHeight());
					imageView.setLayoutParams(params);
				}
			} else {
				LayoutParams params = new LayoutParams(
						LayoutParams.MATCH_PARENT, maxHeight * 1
								/ Const.COUNT_HEIGHT);
				imageView.setLayoutParams(params);
			}

		} else if (child.getImageUrl() != null) {
			if (child.getImageWidth() != 0 && child.getImageHeight() != 0) {
				if (child.getImageWidth() <= maxWidth * Const.MIDDLE_WEIGHT) {
					ImageSize imageSize = new ImageSize(child.getImageWidth(),
							child.getImageHeight());
					imageLoader.displayImage(child.getImageUrl(), imageView,
							imageSize);
				} else {
					ImageSize imageSize = new ImageSize(maxWidth,
							child.getImageHeight());
					imageLoader.displayImage(child.getImageUrl(), imageView,
							imageSize);
				}
			} else {
				imageLoader.displayImage(child.getImageUrl(), imageView);
			}
		}
		middleLayout.addView(itemView);
	}

	private void addViewInRight(final ChildView child) {
		if (child.getImage() != 0) {
			imageView.setBackgroundResource(child.getImage());
			if (child.getImageWidth() != 0 && child.getImageHeight() != 0) {
				if (child.getImageWidth() <= maxWidth * Const.RIGHT_WEIGHT) {
					LayoutParams params = new LayoutParams(
							child.getImageWidth(), child.getImageHeight());
					imageView.setLayoutParams(params);
				}
			} else {
				LayoutParams params = new LayoutParams(
						LayoutParams.MATCH_PARENT, maxHeight * 1
								/ Const.COUNT_HEIGHT);
				imageView.setLayoutParams(params);
			}

		} else if (child.getImageUrl() != null) {
			if (child.getImageWidth() != 0 && child.getImageHeight() != 0) {
				if (child.getImageWidth() <= maxWidth * Const.RIGHT_WEIGHT) {
					ImageSize imageSize = new ImageSize(child.getImageWidth(),
							child.getImageHeight());
					imageLoader.displayImage(child.getImageUrl(), imageView,
							imageSize);
				} else {
					ImageSize imageSize = new ImageSize(maxWidth,
							child.getImageHeight());
					imageLoader.displayImage(child.getImageUrl(), imageView,
							imageSize);
				}
			} else {
				imageLoader.displayImage(child.getImageUrl(), imageView);
			}
		}
		rightLayout.addView(itemView);
	}
}
