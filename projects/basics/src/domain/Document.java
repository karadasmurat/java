package domain;

import interfaces.Readable;
import interfaces.Writeable;

public class Document implements Readable, Writeable {

    @Override
    public void write() {
        System.out.println("Writing to the document");
    }

    @Override
    public void read() {
        System.out.println("Reading the document");
    }

}

