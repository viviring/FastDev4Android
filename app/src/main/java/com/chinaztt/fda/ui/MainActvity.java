package com.chinaztt.fda.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.chinaztt.fda.test.CrashTestActivity;
import com.chinaztt.fda.test.GalleryIndicatorActivity;
import com.chinaztt.fda.test.PullListviewActivity;
import com.chinaztt.fda.test.SPCacheActivity;
import com.chinaztt.fda.ui.base.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 当前类注释:
 * 项目名：FastDev4Android
 * 包名：com.chinaztt.fda.ui
 * 作者：江清清 on 15/10/22 08:59
 * 邮箱：jiangqqlmj@163.com
 * QQ： 781931404
 * 公司：江苏中天科技软件技术有限公司
 */
public class MainActvity extends BaseActivity implements View.OnTouchListener {
    private String[] mItems;
    private Class[] mClassItems;
    private LayoutInflater mInflater;
    private ListView lv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItems=this.getResources().getStringArray(R.array.main_list);
        mClassItems=new Class[]{GalleryIndicatorActivity.class,PullListviewActivity.class, SPCacheActivity.class, CrashTestActivity.class};

        lv_main=(ListView)this.findViewById(R.id.lv_main);
        mInflater=getLayouInflater();
        lv_main.setAdapter(new MainAdapter());
        lv_main.setOnItemClickListener(new CustomOnItemClick());


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }


    class CustomOnItemClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               openActivity(mClassItems[position]);
        }
    }
    class MainAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mItems.length;
        }

        @Override
        public Object getItem(int position) {
            return mItems[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Hondler _Honlder=null;
            if(convertView==null){
                convertView=mInflater.inflate(R.layout.lv_main_item,null);
                _Honlder=new Hondler();
                _Honlder.tv_item=(TextView)convertView.findViewById(R.id.tv_item);
                convertView.setTag(_Honlder);
            }else
            {
                _Honlder=(Hondler)convertView.getTag();
            }
            _Honlder.tv_item.setText(mItems[position]);
            return convertView;
        }



    }

    static class Hondler{
        TextView tv_item;
    }


}