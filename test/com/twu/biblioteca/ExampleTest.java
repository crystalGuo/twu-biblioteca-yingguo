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
        String[] args = {};
        BibliotecaApp.main(args);

        assertThat(output.toString(), is("Welcome to Bibliteca!\n"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
