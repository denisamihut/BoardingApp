package com.company;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; 

public class FileUtility {

    public static void writeToFile(List<TicketInfo> plans) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        File file = new File("src/main/resources/ticketInfo.json");

        try {
            writer.writeValue(file, plans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<TicketInfo> readFromFile() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/ticketInfo.json")));
            TicketInfo[] ticketInfos = mapper.readValue(json,TicketInfo[].class );
            List<TicketInfo> t= new ArrayList(Arrays.asList(ticketInfos));
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}