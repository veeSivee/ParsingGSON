package vee.apps.parsinggson;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by binaryvi on 06/06/2016.
 */
public class ReadTxt {

    public String readFile(String filename) {
        try{
            String myData = "";
            File myInternalFile = new File(filename);
            FileInputStream fis = new FileInputStream(myInternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();

            return  myData;

        } catch (IOException e) {
            e.printStackTrace();
            return  e.toString();
        }
    }

}
