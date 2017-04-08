package nz.co.hamishcundy.dash.common.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hamish on 27/03/17.
 */

public class DisruptionDisplayAdapter extends RecyclerView.Adapter<DisruptionDisplayAdapter.DisruptionViewHolder> {


    @Override
    public DisruptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DisruptionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DisruptionViewHolder extends RecyclerView.ViewHolder{

        public DisruptionViewHolder(View itemView) {
            super(itemView);
        }
    }
}
