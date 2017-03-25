package nz.co.hamishcundy.dash.common.network;

import java.util.List;

import nz.co.hamishcundy.dash.common.model.Departure;
import nz.co.hamishcundy.dash.common.network.response.DepartureResponse;
import nz.co.hamishcundy.dash.common.network.response.DisruptionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hamish on 16/03/17.
 */

public interface PtvApi {

    @GET("v3/departures/route_type/{route_type}/stop/{stop_id}")
    Call<DepartureResponse> getDeparturesForStop(@Path("route_type") Integer routeType, @Path("stop_id") Integer stopId);

    @GET("v3/disruptions")
    Call<DisruptionResponse> getDisruptions();
}
