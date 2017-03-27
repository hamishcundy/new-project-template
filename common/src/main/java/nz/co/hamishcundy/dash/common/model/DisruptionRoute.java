package nz.co.hamishcundy.dash.common.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hamish on 25/03/17.
 */

public class DisruptionRoute {

    @SerializedName("route_number")
    public String routeNumber;

    public boolean inArray(String[] routeNumbers) {
        for(String route:routeNumbers){
            if(route.equals(routeNumber)){
                return true;
            }
        }
        return false;
    }
}
