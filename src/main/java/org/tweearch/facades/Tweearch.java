package org.tweearch.facades;

import org.tweearch.exceptions.TweearchException;
import org.tweearch.parser.Search;

/**
 * User: Angelo Albiero Neto
 * Date: 1/30/12
 * Time: 10:17 AM
 */
public class Tweearch {

    private final String URL = "http://search.twitter.com/search.json?";

    private Search search;

    public Tweearch createSearch(Search search) {
        this.search = search;
        return this;
    }

    public String getUrl() throws TweearchException {
        return URL + search.build();
    }

}
