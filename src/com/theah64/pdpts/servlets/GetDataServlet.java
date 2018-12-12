package com.theah64.pdpts.servlets;

import com.google.gson.GsonBuilder;
import com.theah64.pdpts.database.Data;
import com.theah64.pdpts.pojos.DataBean;
import com.theah64.pdpts.responses.GetDataResponse;
import com.theah64.pdpts.utils.APIResponse;
import com.theah64.pdpts.youtube.YouTubeAPI;
import com.theah64.pdpts.youtube.responses.ChannelStatsResponse;
import com.theah64.webengine.database.querybuilders.QueryBuilderException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/v1/get_data"})
public class GetDataServlet extends HttpServlet {

    private static final String PEW_DIE_PIE_CHANNEL_ID = "UC-lHJZR3Gqxm24_Vd_AJ5Yw";
    private static final String T_SERIES_CHANNEL_ID = "UCq-Fj5jknLsUf-MWSy4_brA";

    private static final String CONTENT_TYPE_JSON = "application/json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType(CONTENT_TYPE_JSON);

        try {

            final ChannelStatsResponse pdpStats = YouTubeAPI.getStatistics(PEW_DIE_PIE_CHANNEL_ID);
            final ChannelStatsResponse tsStats = YouTubeAPI.getStatistics(T_SERIES_CHANNEL_ID);

            if (pdpStats != null && tsStats != null) {

                // Output
                final String tsSubCountString = tsStats.getItems().get(0).getStatistics().getSubscribercount();
                final String pdpSubCountString = pdpStats.getItems().get(0).getStatistics().getSubscribercount();

                // conversion for comparison
                final BigInteger tsSub = new BigInteger(tsSubCountString);
                final BigInteger pdpSub = new BigInteger(pdpSubCountString);
                final BigInteger diff = tsSub.subtract(pdpSub);
                final int cmpRes = tsSub.compareTo(pdpSub);
                String lead;
                if (cmpRes == 0) {
                    lead = "both";
                } else if (cmpRes > 0) {
                    lead = "t_series";
                } else {
                    // < 0
                    lead = "pew_die_pie";
                }

                final GetDataResponse getDataResponse = new GetDataResponse(
                        tsSubCountString,
                        pdpSubCountString,
                        new GetDataResponse.Analysis(
                                lead,
                                diff.abs().toString()
                        ));

                // Adding to db
                Data.getInstance().add(new DataBean(
                        null,
                        pdpSubCountString,
                        tsSubCountString,
                        null
                ));

                final String jsonResp = new GsonBuilder()
                        .setPrettyPrinting()
                        .setLenient()
                        .create().toJson(getDataResponse);

                resp.getWriter().write(
                        new APIResponse("OK", new JSONObject(jsonResp))
                                .getResponse()
                );

            } else {
                throw new IOException("Couldn't get data from Youtube API");
            }


        } catch (IOException | JSONException | SQLException | QueryBuilderException e) {
            e.printStackTrace();

            // SERVER ERROR
            resp.getWriter().write(
                    new APIResponse(
                            e.getMessage()
                    ).getResponse()
            );
        }


    }

}
