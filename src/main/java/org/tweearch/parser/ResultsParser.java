package org.tweearch.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.tweearch.beans.Result;
import org.tweearch.beans.Tweet;
import org.tweearch.beans.TwitterUser;
import org.tweearch.exceptions.TweearchException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * User: Angelo Albiero Neto
 * Date: 1/30/12
 * Time: 10:34 AM
 */
public class ResultsParser {

    private String json;

    private JSONObject jsonObject;

    public ResultsParser(String json) {
        this.json = json;

    }

    public Result parseResult() throws TweearchException {

        try {
            this.jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            throw new TweearchException("O resultado da busca não está em formato JSON válido");
        }

        Result result = new Result();

        try {
            result.setMaxId(jsonObject.getLong("max_id"));
            result.setPage(jsonObject.getInt("page"));
            result.setRpp(jsonObject.getInt("results_per_page"));
            result.setSinceId(jsonObject.getLong("since_id"));

            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                Tweet tweet = new Tweet();

                String date = jsonArray.getJSONObject(i).getString("created_at");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");

                Calendar calendar = new GregorianCalendar();

                try {
                    calendar.setTime(simpleDateFormat.parse(date));
                } catch (ParseException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                tweet.setCreatedAt(calendar);

                tweet.setId(jsonArray.getJSONObject(i).getLong("id"));

                tweet.setLanguage(jsonArray.getJSONObject(i).getString("iso_language_code"));
                tweet.setProfileURL(jsonArray.getJSONObject(i).getString("profile_image_url"));
                tweet.setText(jsonArray.getJSONObject(i).getString("text"));

                TwitterUser twitterUser = new TwitterUser();
                twitterUser.setUsername(jsonArray.getJSONObject(i).getString("from_user"));
                twitterUser.setUserId(jsonArray.getJSONObject(i).getLong("from_user_id"));
                twitterUser.setName(jsonArray.getJSONObject(i).getString("from_user_name"));

                tweet.setFromUser(twitterUser);

                result.getTweets().add(tweet);
            }

        } catch (JSONException e) {
            throw new TweearchException("Ocorreu algum problema ao fazer o parser dos atributos");
        }

        return result;
    }
}
