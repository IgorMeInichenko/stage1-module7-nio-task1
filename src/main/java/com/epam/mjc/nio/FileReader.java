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
            try{
                correctAge = Integer.valueOf(ageLine[1]);
            }
            catch (Exception e){
                correctAge = null;
            }
            try {
                correctNumber = Long.valueOf(phoneLine[1]);
            }
            catch (Exception e){
                correctNumber = null;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new Profile(nameLine[1], correctAge, emailLine[1], correctNumber);
    }
}
