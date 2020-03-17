package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }
    public static Catalog load(String path) throws InvalidCatalogException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Catalog myCatalog = (Catalog) ois.readObject();

            ois.close();
            return myCatalog;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

        public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.getDesktop().browse(new URI(doc.getLocation()));

    }
    private void testLoadView() throws CatalogUtil.InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {

        Catalog catalog = CatalogUtil.load("c://java//catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);


    }

    public static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }

}
