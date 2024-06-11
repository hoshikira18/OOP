/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author VIET
 */
public class ConvertMethods {

    public String convertNumToChar(int number) {
        String newChar;
        if (number < 0 || number > 15) {
            return null;
        } else {
            switch (number) {
                case 10:
                    newChar = "A";
                    break;
                case 11:
                    newChar = "B";
                    break;
                case 12:
                    newChar = "C";
                    break;
                case 13:
                    newChar = "D";
                    break;
                case 14:
                    newChar = "E";
                    break;
                case 15:
                    newChar = "F";
                    break;
                default:
                    newChar = String.valueOf(number);
            }
        }

        return newChar;
    }

    public int convertCharToNum(char oldchar) {
        int newNum;
        String string = String.valueOf(oldchar);
        if (string.matches("[^0-9A-F]")) {
            return -1;
        } else {
            switch (string) {
                case "A":
                    newNum = 10;
                    break;
                case "B":
                    newNum = 11;
                    break;
                case "C":
                    newNum = 12;
                    break;
                case "D":
                    newNum = 13;
                    break;
                case "E":
                    newNum = 14;
                    break;
                case "F":
                    newNum = 15;
                    break;
                default:
                    newNum = Integer.parseInt(string);
            }
        }
        return newNum;
    }

    public String convert2To10(String number) {
        int newNum = 0;
        int powerOf2 = 1;
        for (int i = number.length() - 1; i >= 0; i--) {//caculate from the tail to head
            String charAtI = String.valueOf(number.charAt(i));
            newNum += Integer.parseInt(charAtI) * powerOf2;
            powerOf2 *= 2;
        }
        String strNewNum = String.valueOf(newNum);
        return strNewNum;
    }

    public String convert10To16(String number) {
        int oldNum = Integer.parseInt(number);
        String newNum = "";
        while (oldNum > 0) {
            int soDu = oldNum % 16;
            newNum = convertNumToChar(soDu) + newNum;// add to front of newNum
            oldNum /= 16;
        }
        return newNum;
    }

    public String convert16To10(String number) {
        int newNum = 0;
        int powerOf16 = 1;
        for (int i = number.length() - 1; i >= 0; i--) {//caculate from the tail to head
            char charAtI = number.charAt(i);
            newNum += convertCharToNum(charAtI) * powerOf16;
            powerOf16 *= 16;
        }
        String strNewNum = String.valueOf(newNum);
        return strNewNum;
    }

    public String convert10To2(String number) {
        int oldNum = Integer.parseInt(number);
        String newNum = "";
        while (oldNum > 0) {
            int soDu = oldNum % 2;
            newNum = convertNumToChar(soDu) + newNum;// add to front of newNum
            oldNum /= 2;
        }
        return newNum;
    }

    public String convertAToB(String number, int a, int b) {

        String newNum = "";
        if (a == b) {
            return number;
        }
        //det up before working
        int soChia = b;
        String duKey = "";
        String soBiChiaKey = number;

        while (Integer.parseInt(soBiChiaKey) > 0) {

            String soThuong = "0";

            int n = soBiChiaKey.length();
            String[] listSBCKey = soBiChiaKey.split("");

            String duSP = "";
            int soBiChia = 0;
            
            //do the sub to find the duSP to put to duKey
            for (int i = 0; i < n; i++) {s
                //add value for soBiChia
                soBiChia = soBiChia * a + Integer.parseInt(listSBCKey[i]);
                
                //add new value for thuong and soBiChia
                soThuong += String.valueOf(soBiChia / soChia);
                soBiChia = (soBiChia % soChia);
                // get duSP (the last duSP is what we need)
                duSP = String.valueOf(soBiChia);
            }
            duKey = duSP + duKey;

            // put new value for soBiChiaKey
            int intOfSoThuong = Integer.parseInt(soThuong);
            soBiChiaKey = String.valueOf(intOfSoThuong);

        }
        // update string newNum
        String updateStr = String.valueOf(duKey) + newNum;
        newNum = updateStr;

        return newNum;
    }

}

