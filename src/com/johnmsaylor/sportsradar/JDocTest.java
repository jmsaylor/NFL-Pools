package com.johnmsaylor.sportsradar;

import com.americanexpress.unify.jdocs.BaseUtils;
import com.americanexpress.unify.jdocs.Document;
import com.americanexpress.unify.jdocs.JDocument;
import com.fasterxml.jackson.core.*;

import java.util.concurrent.ExecutionException;

public class JDocTest {
    public static Document doc;



    public static void showJson(){
        String json = "";
        try {
            json = GamePlayerStats.getGamePlayerStats();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doc = new JDocument(json);

        System.out.println(doc.getPrettyPrintJson());
    }
}
