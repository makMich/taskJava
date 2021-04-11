package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.ColoredRectangle;
import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.util.Scanner;

public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(new File(fileName));) {
            fos.write(array);
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        byte[] arrayRead = null;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            arrayRead = new byte[fis.available()];
            fis.read(arrayRead);
        }
        return arrayRead;
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        byte[] arrayRead = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            arrayRead = new byte[fis.available()];
            fis.read(arrayRead);
        }
        return arrayRead;
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] array1 = null;
        byte[] array2;
        if (array.length % 2 == 0) {
            array2 = new byte[array.length / 2];
        } else {
            array2 = new byte[array.length / 2 + 1];
        }
        int increment = 0;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(array.length)) {
            baos.write(array);
            array1 = baos.toByteArray();
        }
        try (ByteArrayInputStream bais = new ByteArrayInputStream(array1)) {
            while (bais.available() != 0) {
                bais.read(array2, increment, 1);
                bais.skip(1);
                increment++;
            }
        }
        return array2;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)))) {
            bos.write(array);
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            bos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        byte[] arrayRead = null;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            arrayRead = new byte[bis.available()];
            bis.read(arrayRead);
        }
        return arrayRead;
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        Rectangle rectangle = new Rectangle();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            rectangle.setTopLeft(new Point(dis.readInt(), dis.readInt()));
            rectangle.setBottomRight(new Point(dis.readInt(), dis.readInt()));
        }
        return rectangle;
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
            dos.writeUTF(rect.getColor().toString());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws ColorException, IOException {
        ColoredRectangle coloredRectangle = new ColoredRectangle();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            coloredRectangle.setTopLeft(new Point(dis.readInt(), dis.readInt()));
            coloredRectangle.setBottomRight(new Point(dis.readInt(), dis.readInt()));
            coloredRectangle.setColor(dis.readUTF());
        }
        return coloredRectangle;
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < rects.length; i++) {
                dos.writeInt(rects[i].getTopLeft().getX());
                dos.writeInt(rects[i].getTopLeft().getY());
                dos.writeInt(rects[i].getBottomRight().getX());
                dos.writeInt(rects[i].getBottomRight().getY());
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        Rectangle[] rects = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            rects = new Rectangle[dis.available() / 16];
            for (int i = 0; i < dis.available(); i++) {
                rects[(dis.available() / 16) - 1] = new Rectangle(new Point(dis.readInt(), dis.readInt()),
                        new Point(dis.readInt(), dis.readInt()));
            }
        }
        return rects;
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (DataOutputStream osw = new DataOutputStream(new FileOutputStream(file))) {
            osw.writeInt(rect.getTopLeft().getX());
            osw.writeInt(rect.getTopLeft().getY());
            osw.writeInt(rect.getBottomRight().getX());
            osw.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException {
        Rectangle rectangle = new Rectangle();
        try (DataInputStream s = new DataInputStream(new FileInputStream(file))) {
            rectangle.setTopLeft(new Point(s.readInt(), s.readInt()));
            rectangle.setBottomRight(new Point(s.readInt(), s.readInt()));
        }
        return rectangle;
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(rect.getTopLeft().getX());
            bw.newLine();
            bw.write(rect.getTopLeft().getY());
            bw.newLine();
            bw.write(rect.getBottomRight().getX());
            bw.newLine();
            bw.write(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        Rectangle rectangle = new Rectangle();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            int a = br.read();
            br.readLine();
            int b = br.read();
            br.readLine();
            int c = br.read();
            br.readLine();
            int d = br.read();
            rectangle.setTopLeft(new Point(a, b));
            rectangle.setBottomRight(new Point(c, d));
        }
        return rectangle;
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws TrainingException, IOException {
        Trainee trainee = new Trainee();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            StringBuilder sb = new StringBuilder(br.readLine());
            String[] splitted = sb.toString().split(" ");
            trainee.setFirstName(splitted[0]);
            trainee.setLastName(splitted[1]);
            trainee.setRating(Integer.parseInt(splitted[2]));
        }
        return trainee;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFirstName() + "\n" + trainee.getLastName() + "\n" + trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws TrainingException, IOException {
        Trainee trainee = new Trainee();
        String[] string = new String[3];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                string[i] = line;
                line = reader.readLine();
                i++;
            }
            trainee.setFirstName(string[0]);
            trainee.setLastName(string[1]);
            trainee.setRating(2);
        }
        return trainee;
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        Trainee trainee = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            trainee = (Trainee) ois.readObject();
        }
        return trainee;
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        return new Gson().toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        return new Gson().fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            new Gson().toJson(trainee, bw);
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Trainee trainee = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            trainee = new Gson().fromJson(br, Trainee.class);
        }
        return trainee;
    }
}

