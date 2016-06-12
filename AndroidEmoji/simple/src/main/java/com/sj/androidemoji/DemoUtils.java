package com.sj.androidemoji;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by sj on 16/3/22.
 */
public class DemoUtils {

    public static final String DEF_FILEPATH = "/AndroidEmoji/emoji";

    public static String getFolderPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + DEF_FILEPATH;
    }

    public static void unzipEmoji(Context context, String emojiZipFileName) {
        String filePath = DemoUtils.getFolderPath() + "/" + emojiZipFileName.substring(0, emojiZipFileName.indexOf("."));
        File dest = new File(filePath);
        if (dest.exists()) {
            return;
        }
        try {
            DemoUtils.unzip(context.getAssets().open(emojiZipFileName), DemoUtils.getFolderPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzip(InputStream is, String dir) throws IOException {
        File dest = new File(dir);
        if (!dest.exists()) {
            dest.mkdirs();
        }

        if (!dest.isDirectory())
            throw new IOException("Invalid Unzip destination " + dest);
        if (null == is) {
            throw new IOException("InputStream is null");
        }

        ZipInputStream zip = new ZipInputStream(is);

        ZipEntry ze;
        while ((ze = zip.getNextEntry()) != null) {
            final String path = dest.getAbsolutePath()
                    + File.separator + ze.getName();

            String zeName = ze.getName();
            char cTail = zeName.charAt(zeName.length() - 1);
            if (cTail == File.separatorChar) {
                File file = new File(path);
                if (!file.exists()) {
                    if (!file.mkdirs()) {
                        throw new IOException("Unable to create folder " + file);
                    }
                }
                continue;
            }

            FileOutputStream fout = new FileOutputStream(path);
            byte[] bytes = new byte[1024];
            int c;
            while ((c = zip.read(bytes)) != -1) {
                fout.write(bytes, 0, c);
            }
            zip.closeEntry();
            fout.close();
        }
    }
}

