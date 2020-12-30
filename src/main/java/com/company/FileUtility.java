package com.company;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {

    public static void writeToFile(TicketInfo plan) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        File file = new File("src/main/resources/ticketInfo.json");

        try {
            writer.writeValue(file, plan);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TicketInfo readFromFile() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/plan.json")));
            TicketInfo ticketInfo = mapper.readValue(json, TicketInfo.class);
            return ticketInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}