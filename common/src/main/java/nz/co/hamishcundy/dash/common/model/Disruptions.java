package nz.co.hamishcundy.dash.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hamish on 25/03/17.
 */

public class Disruptions {

    @SerializedName("general")
    List<Disruption> generalDisruptions;

    @SerializedName("metro_tram")
    List<Disruption> tramDisruptions;

}
