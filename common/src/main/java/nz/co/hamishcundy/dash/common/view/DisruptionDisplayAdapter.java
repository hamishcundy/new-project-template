package nz.co.hamishcundy.dash.common.view;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


import nz.co.hamishcundy.dash.common.R;
import nz.co.hamishcundy.dash.common.model.Disruption;

/**
 * Created by hamish on 27/03/17.
 */

public class DisruptionDisplayAdapter extends RecyclerView.Adapter<DisruptionDisplayAdapter.DisruptionViewHolder> {

    private final Context con;
    private List<Disruption> disruptionList;

    public DisruptionDisplayAdapter(Context con, List<Disruption> disruptions) {
        this.disruptionList = disruptions;
        this.con = con;
    }

    @Override
    public DisruptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DisruptionViewHolder(LayoutInflater.from(con).inflate(R.layout.list_item_disruption_light, parent, false));
    }

    @Override
    public void onBindViewHolder(DisruptionViewHolder holder, int position) {
        holder.bind(disruptionList.get(position));
    }

    @Override
    public int getItemCount() {
        return disruptionList.size();
    }

    public class DisruptionViewHolder extends RecyclerView.ViewHolder{

        public TextView disruptionTitle;
        public TextView disruptionDescription;

        public DisruptionViewHolder(View itemView) {
            super(itemView);

            disruptionTitle = (TextView) itemView.findViewById(R.id.disruption_title);
            disruptionDescription = (TextView) itemView.findViewById(R.id.disruption_description);

        }

        public void bind(Disruption disruption){

            disruptionTitle.setText(disruption.title);
            disruptionDescription.setText(disruption.description);
        }
    }

}
