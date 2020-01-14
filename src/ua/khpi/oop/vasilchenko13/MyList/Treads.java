package ua.khpi.oop.vasilchenko13.MyList;

import ua.khpi.oop.vasilchenko13.First.Recruitment;

import java.util.concurrent.Callable;



public class Treads {

   

    public static class MyTread1 implements Callable<Boolean> {
        LinkedContainer<Recruitment> linkedContainer;

        @Override
        public Boolean call() {
            maxMinPayment();
            return true;
        }

//        @Override
//        public void run() {
// maxMinPayment();
//        }

        private void maxMinPayment() {
            int max = linkedContainer.getElementByIndex(0).getPayment();
            int min = linkedContainer.getElementByIndex(0).getPayment();
            for (int i = 0; i < linkedContainer.size(); i++) {
                if (linkedContainer.getElementByIndex(i).getPayment() < min) {
                    min = linkedContainer.getElementByIndex(i).getPayment();
                }
                if (linkedContainer.getElementByIndex(i).getPayment() > max) {
                    max = linkedContainer.getElementByIndex(i).getPayment();
                }
            }
            System.out.println("Max payment = " + max);
            System.out.println("Min payment = " + min);
        }

        public void set(LinkedContainer<Recruitment> linkedContainer) {
            this.linkedContainer = linkedContainer;
        }


    }

    public static class MyTread2 implements Callable<Boolean> {
        LinkedContainer<Recruitment> linkedContainer;


        private void sumAvgPayment() {
            int sum = 0;
            int avg = 0;
            for (int i = 0; i < linkedContainer.size(); i++) {
                sum += linkedContainer.getElementByIndex(i).getPayment();
            }
            avg = sum / linkedContainer.size();
            System.out.println("Sum payment = " + sum);
            System.out.println("Avg payment = " + avg);
        }

        public void set(LinkedContainer<Recruitment> linkedContainer) {
            this.linkedContainer = linkedContainer;
        }

        @Override
        public Boolean call() throws Exception {
            sumAvgPayment();
            return true;
        }
    }

    public static class MyTread3 implements Callable<Boolean> {
        public static final int HIGHER_PAYMENT = 3000;
        LinkedContainer<Recruitment> linkedContainer;

        @Override
        public Boolean call() throws Exception {
            countHigherPayment();
            return true;
        }

        private void countHigherPayment() {
            int count = 0;
            for (int i = 0; i < linkedContainer.size(); i++) {
                if (linkedContainer.getElementByIndex(i).getPayment() > HIGHER_PAYMENT) {
                    count++;
                }
            }
            System.out.println("Number of vacancies with higher payment: " + count);
        }

        public void set(LinkedContainer<Recruitment> linkedContainer) {
            this.linkedContainer = linkedContainer;
        }
    }
}
