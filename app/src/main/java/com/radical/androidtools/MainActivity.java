package com.radical.androidtools;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText mNotifyContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_gotosetting).setOnClickListener(this);
        findViewById(R.id.btn_notify).setOnClickListener(this);
        mNotifyContent = (EditText) findViewById(R.id.tv_notify_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_gotosetting:{
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_notify:{
                String notifyString = mNotifyContent.getText().toString();
                if (!TextUtils.isEmpty(notifyString)) {
                    sendNotification(notifyString);
                }
            }
                break;
            default:
                break;
        }
    }

    private void sendNotification(String content) {
        NotificationCompat.Builder = new NotificationCompat.Builder(getApplicationContext(), null)
                .setContentText(content);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
}
