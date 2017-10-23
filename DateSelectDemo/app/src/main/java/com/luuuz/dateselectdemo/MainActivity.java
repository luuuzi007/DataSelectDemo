package com.luuuz.dateselectdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.luuuz.dateselectdemo.popwindow.DatePickerPopWin;

public class MainActivity extends AppCompatActivity {
    private TextView tv_show_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show_date= (TextView) findViewById(R.id.tv_show_date);
        /**
         * 1.点击后弹出日期选择器
         */

        findViewById(R.id.btn_date_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * DatePickerPopWin 调用的library下popwindow/的类
                 *
                 */

                DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder(MainActivity.this, new DatePickerPopWin.OnDatePickedListener() {
                    @Override
                    public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                        /**
                         * dateDesc就是当前选中的日期
                         */
                        Toast.makeText(MainActivity.this, dateDesc, Toast.LENGTH_SHORT).show();

                        /**
                         * 让选中的日期显示在TextView上
                         */
                        tv_show_date.setText(dateDesc);
                    }
                }).textConfirm("确认") //text of confirm button  右边确认button的显示内容
                        .textCancel("取消") //text of cancel button左边button的显示内容
                        .btnTextSize(16) // button text size
                        .viewTextSize(25) // pick view text size    //挑选出来的button显示字体的大小
                        .colorCancel(Color.parseColor("#000000")) //color of cancel button  //左边字体颜色
                        .colorConfirm(Color.parseColor("#ff0000"))//color of confirm button 右边字体颜色
                        .minYear(1990) //min year in loop//年份的最小值(包含)
                        .maxYear(2018) // max year in loop  //设置年份的最大值(不包含)
                        .dateChose("2017-10-17") // 设置当前年份
                        .build();
                pickerPopWin.showPopWin(MainActivity.this);

            }
        });
    }
}
