package com.example.administrator.test_litepal;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //开始使用litepal数据库进行存储数据
    private EditText name;
    private EditText age;
    private EditText work;

    private Button btn_insert;
    private Button btn_show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //连接数据库
        SQLiteDatabase db = Connector.getDatabase();
        initView();
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        work = (EditText) findViewById(R.id.work);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edt_name = name.getText().toString();
                int edt_age = Integer.parseInt(age.getText().toString());
                String edt_work = work.getText().toString();
                info i = new info();
                i.setName(edt_name);
                i.setAge(edt_age);
                i.setWork(edt_work);
                i.save();//将数据进行保存
                if (i.save()) {
                    Toast.makeText(MainActivity.this, "插入数据成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "插入数据失败", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<info> infos = DataSupport.findAll(info.class);
                for (int i = 0; i < infos.size(); i++) {
                    Log.d("AAA", infos.get(i).getName());
                }
            }
        });
    }

    @OnClick(R.id.name)
    public void onClick() {
    }
}
