package com.inin.purecloud.devops;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DevopsProducer k = new DevopsProducer("kafka-1,kafka-2,kafka-3");
        System.out.println( "Sending data..." );

        System.out.println( "Hello World!" );
    }
}
