package org.tweearch.units;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tweearch.exceptions.TweearchException;
import org.tweearch.facades.Tweearch;
import org.tweearch.parser.Search;

/**
 * User: Angelo Albiero Neto
 * Date: 1/30/12
 * Time: 10:20 AM
 */
public class TweearchUnit {

    @Test
    public void shouldGetUrlForSearchInTwitter() throws TweearchException {
        Search search = new Search();
        search.createQuery("albiere").withLang("pt");

        Tweearch tweearch = new Tweearch();
        Assert.assertEquals("http://search.twitter.com/search.json?q=albiere&lang=pt", tweearch.createSearch(search).getUrl());
    }

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

}
