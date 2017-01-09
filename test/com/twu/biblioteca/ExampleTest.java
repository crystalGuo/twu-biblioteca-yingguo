package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ExampleTest {

    private ByteArrayOutputStream output;

    @Before
    public void setUpStreams() throws Exception {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testWelcomMessage() {
        String expectResult = "Welcome to Bibliteca!\n";
        String[] args = {};
        BibliotecaApp.printWelcomeMessage();

        assertThat(output.toString(), is(expectResult));
    }

    @Test
    public void testShowBookList() {
        String expectResult =
                "Best British and Irish Literature\t" +
                "Jimes\t2015\n" +
                "Best of William Shakespeare\t" +
                "Lindy\t2013\n" +
                "Very British MM\t" +
                "Gray\t2016\n";

        BibliotecaApp.showBookList();

        assertThat(output.toString(), is(expectResult));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
