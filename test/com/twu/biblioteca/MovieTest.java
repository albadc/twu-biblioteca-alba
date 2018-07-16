package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void movieIsCheckedOut() {
        Movie movie = new Movie("X-Men: First Class", "Matthew Vaughn", "2011", 7.8);
        assertTrue(movie.isAvailable());
        movie.checkOut();
        assertFalse(movie.isAvailable());
    }
}