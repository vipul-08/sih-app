package sih.com.sih.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sih.com.sih.Modals.Stage;
import sih.com.sih.R;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder> {

    Context mContext;
    List<Stage> list;

    public ProgressAdapter(Context mContext, List<Stage> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.single_item,null);
        return new ProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgressViewHolder holder, int position) {
        Stage stage = list.get(position);
        if(position==(list.size()-1))
        {
        	holder.sep.setVisibility(View.INVISIBLE);
        }
        if(stage.isStatus()) {
            holder.stage_element.setBackgroundColor(GREEN);
            holder.textView.setText("Item Reached!!");
        }
        else {
            holder.stage_element.setBackgroundColor(RED);
            holder.textView.setText("Waiting for Item!!");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProgressViewHolder extends RecyclerView.ViewHolder {

        View stage_element,sep;
        TextView textView;

        public ProgressViewHolder(View itemView) {
            super(itemView);
            stage_element = itemView.findViewById(R.id.stage_element);
            textView = itemView.findViewById(R.id.statusText);
            sep = itemView.findViewById(R.id.separator);
        }
    }

}
