package sih.com.sih;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sih.com.sih.Adapters.BeaconDeviceAdapter;
import sih.com.sih.Modals.BeaconModel;

public class DeviceList extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    RecyclerView myRecyclerView;
    BeaconDeviceAdapter adapter;
    List<BeaconModel> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_list_activity);

        linearLayoutManager = new LinearLayoutManager(this);
        myRecyclerView = findViewById(R.id.myRecyclerView);

        list = new ArrayList<>();

        adapter = new BeaconDeviceAdapter(this,list);

        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(adapter);

        list.add(new BeaconModel(59,"HMSensor1","10-10-10"));
        list.add(new BeaconModel(89,"HMSensor2","20-20-20"));

        adapter.notifyDataSetChanged();
    }
}
