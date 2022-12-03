package com.epam.mjc.nio;

import java.io.*;


public class FileReader {
    public String myReadLine (BufferedReader reader){
        String result = "";
        try {
            result = reader.readLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public Integer checkAge (String value){
        Integer correctAge = 0;
        try{
            correctAge = Integer.valueOf(value);
        }
        catch (Exception e){
            correctAge = null;
        }
        return correctAge;
    }
    public Long checkNumber (String value){
        Long correctNumber = 0L;
        try{
            correctNumber = Long.valueOf(value);
        }
        catch (Exception e){
            correctNumber = null;
        }
        return correctNumber;
    }

    public Profile getDataFromFile(File file){
        Integer correctAge = 0;
        Long correctNumber = 0L;
        String[] nameLine = new String[2];
        String[] emailLine = new String[2];
        try (InputStream input = new FileInputStream(file)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            nameLine = myReadLine(reader).split(": ");
            String[] ageLine = myReadLine(reader).split(": ");
            emailLine = myReadLine(reader).split(": ");
            String[] phoneLine = myReadLine(reader).split(": ");
            correctAge = checkAge(ageLine[1]);
            correctNumber = checkNumber(phoneLine[1]);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new Profile(nameLine[1], correctAge, emailLine[1], correctNumber);
    }
}
