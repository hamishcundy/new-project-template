package nz.co.hamishcundy.dash.manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.hamishcundy.dash.common.model.Disruption;
import nz.co.hamishcundy.dash.common.network.PtvApi;
import nz.co.hamishcundy.dash.common.network.PtvKeyCalculator;
import nz.co.hamishcundy.dash.common.network.response.DisruptionResponse;
import nz.co.hamishcundy.dash.common.view.DisruptionDisplayAdapter;
import nz.co.hamishcundy.manager.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.disruptionRecycler)
    RecyclerView disruptionRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        PtvApi api = PtvKeyCalculator.getApi();
        api.getDisruptions().enqueue(new Callback<DisruptionResponse>() {
            @Override
            public void onResponse(Call<DisruptionResponse> call, Response<DisruptionResponse> response) {
                processDisruptionsResponse(response.body());
            }

            @Override
            public void onFailure(Call<DisruptionResponse> call, Throwable t) {
                Log.d("MainAc", "Failure");
            }
        });
    }

    private void processDisruptionsResponse(DisruptionResponse response) {


        List<Disruption> disruptionList = response.disruptions.getAllFilteredDisruptions();
        if(disruptionList.size() == 0){
            Toast.makeText(this, "No disruptions", Toast.LENGTH_SHORT).show();
        }else {
            disruptionRecycler.setLayoutManager(new LinearLayoutManager(this));
            DisruptionDisplayAdapter adapter = new DisruptionDisplayAdapter(this, disruptionList);
            disruptionRecycler.setAdapter(adapter);
        }

    }
}
