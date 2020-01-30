package ua.khpi.oop.vasilchenko16.Container;

import ua.khpi.oop.vasilchenko16.Head.Recruitment;

import java.io.*;
import java.util.LinkedList;

public class Container implements Serializable {

    private LinkedList<Recruitment> linkedList = new LinkedList<>();

    public boolean notEmpty() {
        return linkedList.size() > 0;
    }

    public void clear() {
        linkedList.clear();
    }

    public void addLast(Recruitment obj) {
        linkedList.addLast(obj);
    }

    public void add(Recruitment obj) {
        linkedList.add(obj);
    }

    public Object[] toArray() {
        return linkedList.toArray();
    }

    public void addFirst(Recruitment obj) {
        linkedList.addFirst(obj);
    }

    public int size() {
        return linkedList.size();
    }

    public Recruitment getElementByIndex(final int index) {
        return linkedList.get(index);
    }

    public void sortByFirm() {
        linkedList.sort(Recruitment.compareByFirm);
    }

    public void sortByEducation() {
        linkedList.sort(Recruitment.compareByEducation);
    }

    public void sortBySpecialty() {
        linkedList.sort(Recruitment.compareBySpecialty);
    }

    public int search(Recruitment obj) {
        int index = 0;
        for (Recruitment rec : linkedList) {
            if (rec == obj) {
                return index;
            }
        }
        return -1;
    }

    public void save() {
        try {
            File file = new File("save15.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            Recruitment temp;
            System.out.println();
            pw.println(size());
            for (Recruitment recruitment : linkedList) {
                temp = recruitment;
                pw.println(temp.getFirm());
                pw.println(temp.getSpecialty());
                pw.println(temp.getWorkingConditions());
                pw.println(temp.getPayment());
                pw.println(temp.getConfirms());
                if (temp.getConfirms()) {
                    pw.println(temp.getNeedsSpeciality());
                    pw.println(temp.getExperience());
                    pw.println(temp.getEducation());
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    public void remove(Recruitment recruitment){
        linkedList.remove(recruitment);
    }


    public void read() {
        try (BufferedReader br = new BufferedReader(new FileReader("save15.txt"))) {
            Recruitment temp = new Recruitment();
            String line;
            line = br.readLine();
            int count = Integer.parseInt(line);
            for (int i = 0; i < count; i++) {
                line = br.readLine();
                temp.setFirm(line);
                line = br.readLine();
                temp.setSpecialty(line);
                line =  br.readLine();
                temp.setWorkingConditions(line);
                line =  br.readLine();
                temp.setPayment(Integer.parseInt(line));
                line = br.readLine();
                temp.setConfirm(Boolean.parseBoolean(line));
                if (temp.getConfirms()) {
                    line =    br.readLine();
                    temp.setNeedsSpeciality(line);
                    line = br.readLine();
                    temp.setExperience(Integer.parseInt(line));
                    line = br.readLine();
                    temp.setEducation(line);
                }
                linkedList.add(new Recruitment(temp));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String toString() {
        return linkedList.toString();
    }

    public void saveSerializable() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("save.ser"));
            oo.writeObject(linkedList);
            oo.close();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
    }

    public void readSerializable() {
        try {
            FileInputStream fileInput = new FileInputStream("save.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            LinkedList<Recruitment> temp ;
            temp = (LinkedList<Recruitment>) objectInput.readObject();
            System.out.println(temp);
            objectInput.close();
        } catch (Exception exc) {
            System.out.println("Error");
        }
    }

    public void show() {
        int count = 0;
        for (Recruitment s : linkedList) {
            System.out.println("#" + (++count));
            System.out.println(s.toString());
        }
    }
}

