/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.co.hamishcundy.dash.iot;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nz.co.hamishcundy.dash.common.model.Disruption;
import nz.co.hamishcundy.dash.common.network.PtvApi;
import nz.co.hamishcundy.dash.common.network.PtvKeyCalculator;
import nz.co.hamishcundy.dash.common.network.response.DisruptionResponse;
import nz.co.hamishcundy.dash.common.view.DisruptionDisplayAdapter;
import nz.co.hamishcundy.dash.myproject.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Skeleton of the main Android Things activity. Implement your device's logic
 * in this class.
 *
 * Android Things peripheral APIs are accessible through the class
 * PeripheralManagerService. For example, the snippet below will open a GPIO pin and
 * set it to HIGH:
 *
 * <pre>{@code
 * PeripheralManagerService service = new PeripheralManagerService();
 * mLedGpio = service.openGpio("BCM6");
 * mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
 * mLedGpio.setValue(true);
 * }</pre>
 *
 * For more complex peripherals, look for an existing user-space driver, or implement one if none
 * is available.
 *
 */
public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

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
            DisruptionDisplayAdapter adapter = new DisruptionDisplayAdapter(this, disruptionList, R.layout.list_item_disruption_light_small);
            disruptionRecycler.setAdapter(adapter);
        }

    }
}
