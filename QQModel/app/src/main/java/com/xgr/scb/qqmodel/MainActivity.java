package com.xgr.scb.qqmodel;

import android.app.Activity;
import android.app.Dialog;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {


    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.cre_ok);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMyDialog();
            }
        });
    }

    private void showMyDialog() {


        final Dialog dialog = new Dialog(this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(R.layout.dialog_layout);
       WindowManager m = getWindowManager();

        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        float scale = MainActivity.this.getResources().getDisplayMetrics().density;
      window.setGravity(Gravity.RIGHT | Gravity.TOP);
        RelativeLayout rl = (RelativeLayout) MainActivity.this.findViewById(R.id.re_create);
      wl.x =0;
    //   wl.y = (int) (53*scale+0.5f);
   wl.y = rl.getMeasuredHeight();
        // 以下这两句是为了保证按钮可以水平满屏
   wl.width = LayoutParams.WRAP_CONTENT;
    //    wl.alpha = 0.7f;
     wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
     // wl.dimAmount = 0f;
      dialog.onWindowAttributesChanged(wl);

        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);

        dialog.show();
        Button bt = (Button) window.findViewById(R.id.d_bt_1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }


}
