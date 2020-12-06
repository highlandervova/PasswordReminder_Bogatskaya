package main;

import data.Record;
import generator.PasswordGenerator;
import util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static constants.C.*;

public class Main {

    public static void main(String[] args) {
        do {
            System.out.println(CHOOSE_VARIATIONS);
            String action;
            action = Util.creatScanner().nextLine();
            doChosenAction(action);
        } while (true);
    }
    public static void doChosenAction(String action) {
        switch (action) {
            case ADD:
                Scanner scanner = Util.creatScanner();
                Record record = new Record();
                System.out.println(INPUT_LOGIN);
                record.setLogin(scanner.next());
                System.out.println("Input 1 to write password by yourself or input 2 to use password generator");

                int passwordChoice = scanner.nextInt();
                switch (passwordChoice){
                    case 1:
                        System.out.println(INPUT_PASSWORD);
                        record.setPassword(scanner.next());
                        break;
                    case 2:
                        String password = PasswordGenerator.generatePassword();
                        System.out.println("Your password is " + password);
                        record.setPassword(password);
                        break;
                }
                System.out.println(INPUT_RESOURCE);
                record.setResource(scanner.next());
                Util.addRecord(record);
            case SHOW:
                List<Record> records = Util.showRecordsFromFile(new File("records.txt"));
                for(Record fileRecord : records){
                    System.out.println(fileRecord);
                }
                break;
            case EXIT:
                System.exit(0);

        }
    }
}