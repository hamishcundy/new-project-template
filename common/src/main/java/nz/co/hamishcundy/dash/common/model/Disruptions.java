package nz.co.hamishcundy.dash.common.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nz.co.hamishcundy.dash.common.network.PtvApiConstants;

/**
 * Created by hamish on 25/03/17.
 */

public class Disruptions {

    @SerializedName("general")
    List<Disruption> generalDisruptions;

    @SerializedName("metro_tram")
    List<Disruption> tramDisruptions;

    public List<Disruption> getAllFilteredDisruptions(){
        List<Disruption> disruptions = new ArrayList<Disruption>();

        disruptions.addAll(getFilteredDisruptions(generalDisruptions));
        disruptions.addAll(getFilteredDisruptions(tramDisruptions));
        return disruptions;
    }

    private Collection<? extends Disruption> getFilteredDisruptions(List<Disruption> unfiltered) {
        List<Disruption> disruptions = new ArrayList<Disruption>();
        for(Disruption d:unfiltered){
            if(d.isLessThanDays(PtvApiConstants.MAX_DISRUPTION_DAYS) && d.affectsRoutes(PtvApiConstants.MY_ROUTES)){
                disruptions.add(d);
            }
        }
        return disruptions;
    }

}
