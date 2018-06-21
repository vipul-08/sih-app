package sih.com.sih.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sih.com.sih.Modals.BeaconModel;
import sih.com.sih.R;

/**
 * Created by kapil on 21/6/18.
 */

public class BeaconDeviceAdapter extends RecyclerView.Adapter<BeaconDeviceAdapter.BeaconViewHolder> {


    Context mContext;
    List<BeaconModel> list;

    public BeaconDeviceAdapter(Context mContext, List<BeaconModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public BeaconViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.device_element,null);


        return new BeaconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeaconViewHolder holder, int position) {

        final BeaconModel beaconModel = list.get(position);
        holder.deviceName.setText(beaconModel.getName());
        holder.deviceAddress.setText(beaconModel.getMacAddress());
        holder.deviceRssi.setText(String.valueOf(beaconModel.getRssi()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BeaconViewHolder extends RecyclerView.ViewHolder {

        TextView deviceName,deviceRssi,deviceAddress;

        public BeaconViewHolder(View itemView) {
            super(itemView);

            deviceName = (TextView) itemView.findViewById(R.id.device_name);
            deviceRssi = (TextView) itemView.findViewById(R.id.device_rssi);
            deviceAddress = (TextView) itemView.findViewById(R.id.device_address);


        }
    }
}
