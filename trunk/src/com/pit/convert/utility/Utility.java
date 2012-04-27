package com.pit.convert.utility;

import java.io.*;

/**
 * 
 * @author HAIBV
 */
public class Utility {

    /**
     * Lấy toàn bộ những file trong folder
     * @param name
     * @param files 
     */
    public static void dirFiles(String name, String files) {
        try {
            File actual = new File(files);
            for (File f : actual.listFiles()) {
                //System.out.println(name+f.getName());
            }
        } catch (Exception ex) {
        }
    }

    /**
     * move file from folder to folder
     * @param source
     * @param targer 
     */
    public static void moveFiles(String source, String targer) {
        // File (or directory) to be moved
        File file = new File(source);
        // Destination directory
        File dir = new File(targer);
        // Delete file nếu đã tồn tại file đó
        //File f_del = new File(targer+"\\"+file.getName());
        //f_del.delete();              
        // Move file to new directory
        boolean success = file.renameTo(new File(dir, file.getName()));

        if (!success) {
            // File was not successfully moved                
        }
    }
    /**
     * Chuyển đổi font to UTF8
     * @param isoString
     * @return string_utf8
     */
    public static String toUTF8(String isoString) {
        String utf8String = null;
        if (null != isoString && !isoString.equals("")) {
            try {
                byte[] stringBytesISO = isoString.getBytes("ISO-8859-1");
                utf8String = new String(stringBytesISO, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                utf8String = isoString;
            }
        } else {
            utf8String = isoString;
        }
        return utf8String;
    }

    /**
     * Copy file từ thư mục đến thư mục
     * @param srcPath
     * @param dstPath
     * @throws IOException 
     */
    public static void copyDirectory(File srcPath, File dstPath) throws IOException {
        // bỏ trường hợp srcPath = dstPath
        if (!srcPath.equals(dstPath)) {
            if (srcPath.isDirectory()) {
                if (!dstPath.exists()) {
                    dstPath.mkdir();
                }

                String files[] = srcPath.list();
                for (int i = 0; i < files.length; i++) {
                    copyDirectory(new File(srcPath, files[i]), new File(dstPath, files[i]));
                }
            } else {
                if (!srcPath.exists()) {
                    System.out.println("File or directory does not exist.");
                    System.exit(0);
                } else {
                    InputStream in = new FileInputStream(srcPath);
                    OutputStream out = new FileOutputStream(dstPath);

                    // Transfer bytes from in to out
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();
                }
            }
        }
    }

    /**
     * Kiểm tra dữ liệu là kiểu số
     * @param i
     * @return boolean
     */
    public static boolean isNumber(String i) {
        try {
            Integer.parseInt(i);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    /**
     * Thực hiện viết log
     * @param txtIn
     * @param txtEx
     * @param v_oracle 
     */
    public static void exLog(String txtIn, String txtEx, char v_oracle) {
        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(txtIn);

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // Create file 
            FileWriter fw = new FileWriter(txtEx);
            BufferedWriter out = new BufferedWriter(fw);

            String strLine = null;
            String lines[] = null;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                lines = strLine.split(":");
                //value oracle
                if (v_oracle == 'X') {
                    out.write("'" + lines[1] + "',");
                    out.newLine();
                } else {
                    out.write(lines[1]);
                    out.newLine();
                }

            }
            //Close the input & output stream
            out.close();
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
