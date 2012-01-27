package org.tweearch.units;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tweearch.enums.ResultType;
import org.tweearch.exceptions.TweearchException;
import org.tweearch.parser.Search;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * User: Angelo Albiero Neto
 * Date: 1/27/12
 * Time: 4:33 PM
 */
public class SearchUnit {

    @Test
    public void shouldParserQueryToParameters() throws TweearchException {
        Search search = new Search();

        String parameters = search.createQuery("albiere").build();
        Assert.assertEquals("q=albiere", parameters);
    }

    @Test
    public void shouldParserQueryAndLangToParameters() throws TweearchException {
        Search search = new Search();
        String parameters = search.createQuery("albiere").withLang("pt").build();
        Assert.assertEquals("q=albiere&lang=pt", parameters);
    }

    @Test
    public void shouldParserQueryAndEntitiesToParameters() throws TweearchException {
        Search search = new Search();
        String parameters = search.createQuery("albiere").withEntities(true).build();
        Assert.assertEquals("q=albiere&include_entities=1", parameters);
    }

    @Test
    public void shouldParserQueryAndRppToParameters() throws TweearchException {
        Search search = new Search();
        String parameters = search.createQuery("albiere").withPage(1).build();
        Assert.assertEquals("q=albiere&page=1", parameters);
    }

    @Test
    public void shouldParserQueryAndPageToParameters() throws TweearchException {
        Search search = new Search();
        String parameters = search.createQuery("albiere").withRpp(100).build();
        Assert.assertEquals("q=albiere&rpp=100", parameters);
    }

    @Test
    public void shouldParserQueryAndSinceToParameters() throws TweearchException {
        Search search = new Search();

        Calendar calendar = new GregorianCalendar();
        calendar.set(2012, 0, 27);

        String parameters = search.createQuery("albiere").withUntil(calendar).build();
        Assert.assertEquals("q=albiere&until=2012-01-27", parameters);
    }

    @Test
    public void shouldParserQueryAndResultTypeToParameters() throws TweearchException {
        Search search = new Search();

        String parameters = search.createQuery("albiere").withResultType(ResultType.RECENT).build();
        Assert.assertEquals("q=albiere&result_type=recent", parameters);
    }

    @Test
    public void shouldParserQueryAndSinceIdToParameters() throws TweearchException {
        Search search = new Search();

        String parameters = search.createQuery("albiere").withSinceId(12).build();
        Assert.assertEquals("q=albiere&since_id=12", parameters);
    }

    @Test
    public void shouldParserQueryAndSinceAndPageAndRppAndEntitiesAndLangToParameters() throws TweearchException {
        Search search = new Search();

        Calendar calendar = new GregorianCalendar();
        calendar.set(2012, 0, 27);

        String parameters = search.createQuery("albiere").withRpp(100).withPage(1).withLang("pt").withEntities(true).withUntil(calendar).build();
        Assert.assertEquals("q=albiere&lang=pt&include_entities=1&page=1&rpp=100&until=2012-01-27", parameters);
    }

    @Test
    public void shouldThrowExceptionOnInvalidQuery() {
        Search search = new Search();

        try {
            search.withSinceId(12).build();
            Assert.fail();
        } catch (TweearchException e) {

        }

        try {
            search.createQuery("").build();
            Assert.fail();
        } catch (TweearchException e) {

        }

        try {
            search.createQuery(null).build();
            Assert.fail();
        } catch (TweearchException e) {
        }

    }


    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }
}
