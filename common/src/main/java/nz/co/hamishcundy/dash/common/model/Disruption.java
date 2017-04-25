package nz.co.hamishcundy.dash.common.model;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hamish on 19/03/17.
 */

public class Disruption {


    public String title;
    public String description;

    @SerializedName("from_date")
    public Date fromDate;

    @SerializedName("to_date")
    public Date toDate;

    public List<DisruptionRoute> routes;

    public boolean isLessThanDays(int days){
        if(toDate == null || fromDate == null){
            return true;
        }
        long diff = toDate.getTime() - fromDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if(days > diffDays){
            return true;
        }
        return false;

    }

    public boolean affectsRoutes(String[] routeNumbers){
        if(routes.size() == 0){//no route specified
            return true;
        }
        for(DisruptionRoute route:routes){
            if(route.inArray(routeNumbers)){
                return true;
            }
        }
        return false;

    }


}
