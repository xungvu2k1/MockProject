package com.paci.training.android.xungvv.mockproject.view.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;
import com.paci.training.android.xungvv.mockproject.view.mostpopularfruit.MostPopularFruitsActivity;
import com.paci.training.android.xungvv.mockprojectserver.IMyAidlInterface;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    //var
    Fruit selectedFruit;
    //view
    private TextView tvNameOfFruit;
    private TextView tvBack;
    private TextView tvDetailFruit;
    //service
    IMyAidlInterface iMyAidlInterface;
    String TAG = "checkService";

    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            Log.e(TAG, "Remote config Service Connected!!!");
            try {
                String fruitDetail = iMyAidlInterface.getFruitDetail(selectedFruit.getId());
                tvDetailFruit.setText(fruitDetail);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "Service has unexpectedly disconnected");
            iMyAidlInterface = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNameOfFruit = findViewById(R.id.tv_name_of_fruit);//
        tvBack = findViewById(R.id.tv_back_detail);
        tvDetailFruit = findViewById(R.id.tv_about_the_fruit);

        //set name fruit from mostpopularfruitactivity
        setFruitName();

        // bind service
        Intent intent = new Intent("AIDLDetailService");
        intent.setPackage("com.paci.training.android.xungvv.mockprojectserver");

        bindService(intent,mServiceConnection, BIND_AUTO_CREATE);

        tvBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(DetailActivity.this, MostPopularFruitsActivity.class);
                startActivity(intentBack);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void setFruitName() {
        Bundle bundle =  getIntent().getExtras();
        if (bundle != null){
            selectedFruit = (Fruit) bundle.getSerializable("current_fruit");
            String fruitName = selectedFruit.getName();
            tvNameOfFruit.setText(fruitName);
        }
    }
}