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

    public boolean isGreaterThanOneDay(){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return !fmt.format(fromDate).equals(fmt.format(toDate));

    }

    public boolean affectsRoutes(String[] routeNumbers){
        for(DisruptionRoute route:routes){
            if(route.inArray(routeNumbers)){
                return true;
            }
        }
        return false;

    }


}
