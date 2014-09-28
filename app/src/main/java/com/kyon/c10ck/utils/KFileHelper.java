package com.kyon.c10ck.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by slynero on 14-9-28.
 * Copyright © 2014 FineSoft. All rights reserved.
 */
public class KFileHelper {
    private boolean hasSD;
    private String SDPath;
    private String appPath;

    public KFileHelper(Context context) {
        initParams(context);

    }

    private void initParams(Context context) {
        hasSD = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        SDPath = Environment.getExternalStorageDirectory().getPath();
        appPath = context.getFilesDir().getPath();
    }

    public File createSDFile(String fileName) {
        File file = new File(SDPath + "//" + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                KLogger.error(e.getMessage());
            }
        }
        return file;

    }

    public boolean deleteSDFile(String fileName) {
        File file = new File(SDPath + "//" + fileName);
        if (file == null || !file.exists() || file.isDirectory()) {
            return false;
        }
        return file.delete();
    }

    public String readSDFile(String fileName) {
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(SDPath + "//" + fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            int ch;
            while ((ch = fis.read()) != -1) {
                stringBuffer.append((char) ch);
            }
            fis.close();

        } catch (FileNotFoundException e) {
            KLogger.error(e.getMessage());
        } catch (IOException e) {
            KLogger.error(e.getMessage());
        }

        return stringBuffer.toString();

    }



}
