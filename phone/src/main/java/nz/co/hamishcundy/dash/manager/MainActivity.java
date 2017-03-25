package nz.co.hamishcundy.dash.manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nz.co.hamishcundy.dash.common.network.PtvApi;
import nz.co.hamishcundy.dash.common.network.PtvKeyCalculator;
import nz.co.hamishcundy.dash.common.network.response.DisruptionResponse;
import nz.co.hamishcundy.manager.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PtvApi api = PtvKeyCalculator.getApi();
        api.getDisruptions().enqueue(new Callback<DisruptionResponse>() {
            @Override
            public void onResponse(Call<DisruptionResponse> call, Response<DisruptionResponse> response) {

            }

            @Override
            public void onFailure(Call<DisruptionResponse> call, Throwable t) {

            }
        });
    }
}
