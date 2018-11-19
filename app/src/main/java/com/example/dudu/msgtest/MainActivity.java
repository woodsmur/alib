package com.example.dudu.msgtest;

import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymessagelibrary.MyView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        initializeMessageLibrary();
    }

    private void initializeMessageLibrary() {
        MyView view = new MyView(this);
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.bottom_layout);
        linearLayout.addView(view);
    }

    private void initialize() {
        // Some existing RelativeLayout from your layout xml
//        RelativeLayout rl = (RelativeLayout) findViewById(R.id.menu);
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(30, 40);
//        params.leftMargin = 50;
//        params.topMargin = 60;

//        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.menu);
//        if (layout == null) {
//            Toast.makeText(MainActivity.this, "Layout == null", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(MainActivity.this, "layout !+ null", Toast.LENGTH_LONG).show();
//        }

        LayoutInflater flater = LayoutInflater.from(this);
        View view = flater.inflate(R.layout.menu, null);
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(30, 40);
//        params.leftMargin = 50;
//        params.topMargin = 60;

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.bottom_layout);
        linearLayout.addView(view);


        // TODO: 用自定义菜单替换 snackbar
        final Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Had a snack", Snackbar.LENGTH_LONG);
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击确定", Toast.LENGTH_LONG).show();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                snackbar.show();
            }
        }, 2000);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Snackbar.make(findViewById(android.R.id.content), "Had a snack at Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Undo", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Toast.makeText(MainActivity.this, "点击确定", Toast.LENGTH_LONG).show();
//                            })
//                            .setActionTextColor(Color.RED)
//                        .show();
//                        }
//            },2000);

        final Handler handler = new Handler();
        handler.postDelayed(new
            Runnable() {
                @Override
                public void run () {
                    TextView tv = (TextView) findViewById(R.id.info);
                    String pkgName = getPackageName();
                    tv.setText("我很好\n" + pkgName);
                }
            }, 2000);
    }
}
