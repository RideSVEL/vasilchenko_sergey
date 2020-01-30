package ua.khpi.oop.vasilchenko01;

import java.lang.String;


class Lab01 {
//	public static void Function1(long number, int pair, int notPair) {
//		int result = 0;
//		while(number!=0) {
//			result =(int) (number %10);
//			number =  (number/10);
//			if(result % 2 ==0) {
//				pair =pair +1;
//			}
//			else {
//				notPair = notPair +1;
//			}
//		}
//		System.out.print("Count of pair numbers = ");
//		System.out.println(pair);
//		System.out.print("Count of not pair numbers = ");
//		System.out.println(notPair);
//	}

    public static void main(String[] args) {
        final short BookNumber = 0x465F;
        final long MobTelephone = 380508819635L;
        final short TwoLastNumber = 0b100011;
        final short FourLastNumber = 022643;
        final int NumberJournal = 2;
        final int ResultJournal = (NumberJournal - 1) % 26 + 1;
        final char NumberOfSymbol = (char) ResultJournal + 65;
        //System.out.println(NumberOfSymbol);
        byte even = 0;
        byte odd = 0;
        byte ones = 0;
        String First;
        String Second;
        //Function1(TwoLastNumber, even, odd);
        First = Integer.toString(BookNumber) + Long.toString(MobTelephone) + Integer.toString(TwoLastNumber)
                + Integer.toString(FourLastNumber) + Integer.toString(NumberJournal)
                + Integer.toString(ResultJournal) + Integer.toString((int) NumberOfSymbol);
        for (byte i = 0; i < First.length(); i++) {
            if (First.charAt(i) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        Second = Integer.toBinaryString(BookNumber) + Long.toBinaryString(MobTelephone) + Integer.toBinaryString(TwoLastNumber)
                + Integer.toBinaryString(FourLastNumber) + Integer.toBinaryString(NumberJournal) + Integer.toBinaryString(ResultJournal)
                + Integer.toBinaryString((int) NumberOfSymbol);

        for (byte i = 0; i < Second.length(); i++) {
            if (Second.charAt(i) % 2 != 0)
                ones++;
        }
        //Function1(FourLastNumber, even, odd)
        System.out.println("Количество четных цифр: " + even);
        System.out.println("Количество нечетных цифр: " + odd);
        System.out.println("Количество едениц: " + ones);
    }
}

