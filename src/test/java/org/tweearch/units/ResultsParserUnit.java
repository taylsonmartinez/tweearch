package org.tweearch.units;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tweearch.beans.Result;
import org.tweearch.beans.Tweet;
import org.tweearch.beans.TwitterUser;
import org.tweearch.exceptions.TweearchException;
import org.tweearch.parser.ResultsParser;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * User: Angelo Albiero Neto
 * Date: 1/31/12
 * Time: 2:05 PM
 */
public class ResultsParserUnit {

    private String resultJson;

    private ResultsParser resultsParser;

    @Test
    public void shouldParseMaxIdToObject() throws TweearchException {
        Result result = new Result();
        result.setMaxId(162676729649963009l);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getMaxId(), resultParam.getMaxId());
    }

    @Test
    public void shouldParsePageToObject() throws TweearchException {
        Result result = new Result();
        result.setPage(1);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getPage(), resultParam.getPage());
    }

    @Test
    public void shouldParseRppToObject() throws TweearchException {
        Result result = new Result();
        result.setRpp(100);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getRpp(), resultParam.getRpp());
    }

    @Test
    public void shouldParseSinceIdToObject() throws TweearchException {
        Result result = new Result();
        result.setSinceId(0l);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getSinceId(), resultParam.getSinceId());
    }

    @Test
    public void shouldParseResultsTwitterUserUsernameToObject() throws TweearchException {
        Result result = new Result();

        TwitterUser user = new TwitterUser();
        user.setUsername("albiere_test");

        Tweet tweet = new Tweet();
        tweet.setFromUser(user);

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getFromUser().getUsername(), resultParam.getTweets().get(0).getFromUser().getUsername());
    }

    @Test
    public void shouldParseResultsTwitterUserUserIdToObject() throws TweearchException {
        Result result = new Result();

        TwitterUser user = new TwitterUser();
        user.setUserId(475335824l);

        Tweet tweet = new Tweet();
        tweet.setFromUser(user);

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getFromUser().getUserId(), resultParam.getTweets().get(0).getFromUser().getUserId());
    }

    @Test
    public void shouldParseResultsTwitterUserNameToObject() throws TweearchException {
        Result result = new Result();

        TwitterUser user = new TwitterUser();
        user.setName("Albiere Test");

        Tweet tweet = new Tweet();
        tweet.setFromUser(user);

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getFromUser().getName(), resultParam.getTweets().get(0).getFromUser().getName());
    }

    @Test
    public void shouldParseResultsTweetIdToObject() throws TweearchException {
        Result result = new Result();

        Tweet tweet = new Tweet();
        tweet.setId(162676729649963009l);

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getId(), resultParam.getTweets().get(0).getId());
    }

    @Test
    public void shouldParseResultsTweetLanguageToObject() throws TweearchException {
        Result result = new Result();

        Tweet tweet = new Tweet();
        tweet.setLanguage("en");

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getLanguage(), resultParam.getTweets().get(0).getLanguage());
    }

    @Test
    public void shouldParseResultsTweetProfileImageToObject() throws TweearchException {
        Result result = new Result();

        Tweet tweet = new Tweet();
        tweet.setProfileURL("http://a0.twimg.com/sticky/default_profile_images/default_profile_5_normal.png");

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getProfileURL(), resultParam.getTweets().get(0).getProfileURL());
    }

    @Test
    public void shouldParseResultsTweetTextToObject() throws TweearchException {
        Result result = new Result();

        Tweet tweet = new Tweet();
        tweet.setText("testando tweet");

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getText(), resultParam.getTweets().get(0).getText());
    }

    @Test
    public void shouldParseResultsTweetCreateAtToObject() throws TweearchException {
        Result result = new Result();

        Tweet tweet = new Tweet();

//        Thu, 26 Jan 2012 23:22:09 +0000
        Calendar calendar = new GregorianCalendar();

        calendar.set(Calendar.YEAR, 2012);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 26);

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 22);
        calendar.set(Calendar.SECOND, 9);

        tweet.setCreatedAt(calendar);

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();

        Assert.assertEquals(result.getTweets().get(0).getCreatedAt().getTime().toString(), resultParam.getTweets().get(0).getCreatedAt().getTime().toString());
    }

    @Test
    public void shouldParseResultsToObject() throws TweearchException {
        Result result = new Result();

        TwitterUser user = new TwitterUser();
        user.setName("Albiere Test");

        Tweet tweet = new Tweet();
        tweet.setFromUser(user);

        result.getTweets().add(tweet);

        Result resultParam = this.resultsParser.parseResult();
        Assert.assertEquals(result.getTweets().get(0).getFromUser().getName(), resultParam.getTweets().get(0).getFromUser().getName());
    }

    @Before
    public void setup() throws IOException {
        File file = new File(this.getClass().getResource("/results.json").getFile());
        this.resultJson = FileUtils.readFileToString(file);

        this.resultsParser = new ResultsParser(this.resultJson);
    }

    @After
    public void tearDown() {

    }

}
