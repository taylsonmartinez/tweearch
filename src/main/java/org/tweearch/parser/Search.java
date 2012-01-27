package org.tweearch.parser;

import org.tweearch.enums.ResultType;
import org.tweearch.exceptions.TweearchException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * User: Angelo Albiero Neto
 * Date: 1/27/12
 * Time: 4:50 PM
 */
public class Search {

    private String otherParameters = "";
    private String query;
    private String lang;
    private boolean entities;
    private int page;
    private int rpp;
    private long sinceId;
    private Calendar until;
    private ResultType resultType;

    public Search setQuery(String query) {
        this.query = query;
        return this;
    }

    public Search setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public Search setEntities(boolean status) {
        this.entities = status;
        return this;
    }

    public Search setPage(int page) {
        this.page = page;
        return this;
    }

    public Search setRpp(int rpp) {
        this.rpp = rpp;
        return this;
    }

    public Search setResultType(ResultType resultType) {
        this.resultType = resultType;
        return this;
    }

    public Search setSinceId(long sinceId) {
        this.sinceId = sinceId;
        return this;
    }

    public Search setUntil(Calendar untilCalendar) {
        this.until = untilCalendar;
        return this;
    }


    public String build() throws TweearchException{

        if (query != null && !query.isEmpty())
            this.query = "q=" + query;
        else
            throw new TweearchException("Invalid search. Query is required");

        if (lang != null && !lang.isEmpty())
            otherParameters += "&lang=" + lang;

        if (entities)
            otherParameters += "&include_entities=1";

        if (page > 0)
            otherParameters += "&page=" + page;

        if (rpp > 0)
            otherParameters += "&rpp=" + rpp;

        if (resultType != null)
            otherParameters += "&result_type=" + resultType.name().toLowerCase();

        if (sinceId > 0)
            otherParameters += "&since_id=" + sinceId;

        if (this.until != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String until = simpleDateFormat.format(this.until.getTime());

            if (until != null && !until.isEmpty())
                otherParameters += "&until=" + until;
        }

        return this.query + this.otherParameters;
    }
}
