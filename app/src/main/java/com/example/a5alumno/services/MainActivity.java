package com.example.a5alumno.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnStartService, btnStartBoundService, btnStartIntentService, btnDispInfo;
    TextView mTextView;
    EditText mEditText;
    BoundService mBoundService;
    private static final String TAG = "In-FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = (Button) findViewById(R.id.btnStartService);
            btnStartService.setOnClickListener(this);

        btnStartBoundService = (Button) findViewById(R.id.btnStartBoundService);
            btnStartBoundService.setOnClickListener(this);

        btnStartIntentService = (Button) findViewById(R.id.btnStartIntentService);
            btnStartIntentService.setOnClickListener(this);

        btnDispInfo = (Button) findViewById(R.id.btnDispInfo);
            btnDispInfo.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.txtViewAction);
        mEditText = (EditText) findViewById(R.id.edtTxtInputInfo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartService:
                Log.e(TAG,"Start Service Button");
                Intent startServiceIntent = new Intent(this, StartedService.class);
                startService(startServiceIntent);
                break;

            case R.id.btnStartBoundService:
                Log.e(TAG,"Start Bound Service Button");
                ServiceConnection boundServiceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        mBoundService = new BoundService(service);
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                };

                Intent boundServiceIntent = new Intent(this,BoundService.class);
                bindService(boundServiceIntent, boundServiceConnection, Context.BIND_AUTO_CREATE);
                startService(boundServiceIntent);
                break;

            case R.id.btnStartIntentService:
                Log.e(TAG,"Start Intent Service Button");
                Intent intentServiceIntent = new Intent(this,MyIntentService.class);
                startService(intentServiceIntent);
                break;

            case R.id.btnDispInfo:
                Log.e(TAG,"Display Info Button");
                this.mTextView.setText(mEditText.getText().toString());
                break;

        }
    }
}
