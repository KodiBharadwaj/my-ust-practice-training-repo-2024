package com.stackroute.streams;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileOperationsUsingStreams {

    public int getUniqueWordCount(String fileName) {
        if (!fileName.endsWith(".txt")) return 0;
        if (fileName.trim().length() == 0) return 0;

//        try {
//            InputStream input = new FileInputStream(fileName);
//            Scanner scanner = new Scanner(input);
//
//            while (scanner.hasNextLine()) {
//                String str = scanner.nextLine();
//                StringBuilder a = new StringBuilder();
//                for (int i = 0; i < str.length(); i++) {
//                    if (str.charAt(i) != ' ') {
//                        a.append(str.charAt(i));
//                    } else {
//                        if (a.length() > 0) {
//                            set.add(a.toString());
//                            a.setLength(0);
//                        }
//                    }
//                }
//                if (a.length() > 0) {
//                    set.add(a.toString());
//                    a.setLength(0);
//                }
//            }
//
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//
//        return set.size();
        String str = "";
        try {
            InputStream input = new FileInputStream(fileName);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
                str += " ";
            }
            String[] stringArray = str.split("\\s+");

            return (int) Arrays.stream(stringArray).distinct().count();


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    public Set<String> getWordListWithoutDuplicates(String fileName) {

        if (fileName.trim().length() == 0) return Collections.emptySet();
        Set<String> set = new HashSet<>();
        String str = "";
        try {
            InputStream input = new FileInputStream(fileName);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
                str += " ";
            }
            String[] stringArray = str.split("\\s+");
             Arrays.stream(stringArray).distinct().forEach(i->set.add(i));

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return set;
    }


    public List<String> getWordListInUppercaseExcludingFirstLine(String fileName){
        if (fileName.trim().length() == 0) return Collections.emptyList();
        fileName.toUpperCase();
        List<String> list = new ArrayList<>();
        String str = "";
        try {
            InputStream input = new FileInputStream(fileName);
            Scanner scanner = new Scanner(input);
            if(scanner.hasNextLine()){
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
                str += " ";
            }
            String[] stringArray = str.split("\\s+");
            Arrays.stream(stringArray).forEach(i->list.add(i));

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return list;
    }



    public String getEachWordsSeparatedByColon(String fileName){
        if (fileName.trim().length() == 0) return null;
        String str = "";
        String finalString;
        try {
            InputStream input = new FileInputStream(fileName);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
                str += " ";
            }

            String[] stringArray = str.split("\\s+");

            finalString = Arrays.stream(stringArray).collect(Collectors.joining(":"));

        } catch (IOException e) {
            return null;
        }
        return finalString;
    }

    public String getEachLineSeparatedByComma(String fileName){
        File file = new File(fileName);
        if(!file.exists()) return null;

        if (fileName.trim().length() == 0) return null;
        String finalString = "";

        try {
            InputStream input = new FileInputStream(fileName);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                finalString += str;
                finalString += ",";
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());;
        }

        return finalString.substring(0,finalString.length()-1);
    }

    public Optional<Integer> getMaxOfIntegers(String fileName){

        File file = new File(fileName);
        if(!file.exists()) return Optional.empty();
        int val = 0;
        if (fileName.trim().length() == 0) return Optional.empty();
        String str = "";

        try {
            InputStream input = new FileInputStream(fileName);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
                str += " ";
            }

            String[] stringArray = str.split("\\s+");
            val = Arrays.stream(stringArray).filter(i->i.matches("[0-9]+")).mapToInt(i->Integer.parseInt(i)).max().orElse(0);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

         if(val == 0) return Optional.empty();

         return Optional.of(val);

    }

    public Optional<Integer> getSumOfIntegers(String fileName){

        File file = new File(fileName);
        if(!file.exists()) return Optional.empty();

        if (fileName.trim().length() == 0) return Optional.empty();
        String str = "";
        int value = 0;
        try {
            InputStream input = new FileInputStream(fileName);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
                str += " ";
            }

            String[] stringArray = str.split("\\s+");
            value = Arrays.stream(stringArray).filter(i->i.matches("[0-9]+")).mapToInt(i->Integer.parseInt(i)).sum();
        } catch (IOException e) {
            System.err.println(e.getMessage());;
        }

        if(value == 0)
        return Optional.empty();
        else return Optional.of(value);
    }

}