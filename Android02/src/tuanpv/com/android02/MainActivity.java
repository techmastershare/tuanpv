package tuanpv.com.android02;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView imv1;
	ImageView imv2;
	ImageView imleft;
	ImageView imright;	
	int j = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String name = "";
		Field[] field = R.drawable.class.getFields();
		final List<Integer> list = new ArrayList<Integer>();
		try {
			for (Field f : field) {
				name = f.getName();
				if(name.equals("buttonleft") || name.equals("buttonright") || name.equals("ic_launcher") || name.equals("screen")){
					
				}else{
					list.add(f.getInt(null));
				}
				
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final int size2 = list.size();
		Log.d("name image", name);

		imv1 = (ImageView) findViewById(R.id.image1);
		imv2 = (ImageView) findViewById(R.id.image2);
		
		imleft = (ImageView) findViewById(R.id.imageleft);
		imleft.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				j = j-2;
				if (j<0) {
					j = size2 - 2;
				}
				imv1.setImageResource(list.get(j));
				imv2.setImageResource(list.get(j+1));
			}
		});
		imright = (ImageView) findViewById(R.id.imageright);
		imright.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				j = j+2;
				if (j>=size2) {
					j = 0;
				}
				imv1.setImageResource(list.get(j));
				imv2.setImageResource(list.get(j+1));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
