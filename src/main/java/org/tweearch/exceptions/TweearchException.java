package org.tweearch.exceptions;

/**
 * User: Angelo Albiero Neto
 * Date: 1/27/12
 * Time: 5:45 PM
 */
public class TweearchException extends Exception {

    public TweearchException(String s) {
        super(s);
    }

    public TweearchException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TweearchException(Throwable throwable) {
        super(throwable);
    }
}
