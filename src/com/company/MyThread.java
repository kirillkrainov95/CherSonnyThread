package com.company;

class MyThread extends Thread {

    int[] index;
    boolean[] singed;
    String[][] lyrics;
    String myName;
    String otherName;

    public MyThread(String name, String[][] lyrics, int[] index, boolean[] singed) {
        myName = name;
        otherName = name == "Sonny" ? "Cher" : "Sonny";

        this.lyrics = lyrics;
        this.index = index;
        this.singed = singed;
    }

    public void run(){

        while (index[0] < lyrics.length) {

            if (lyrics[index[0]][0].contains(myName)) {

                if (lyrics[index[0]][0] == myName) {
                    System.out.println(myName + ": " + lyrics[index[0]][1]);
                    index[0]++;
                } else {
                    System.out.println(myName + ": " + lyrics[index[0]][1]);
                    if (singed[0] == true) {
                        try {
                            if (index[0] == lyrics.length) {
                                System.out.println(otherName + ": " + lyrics[index[0]][1]);
                                break;
                            }

                            if (index[0] > lyrics.length) {
                                System.out.println(otherName + ": " + lyrics[index[0] - 1][1]);
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            return;
                        }

                        singed[0] = false;
                    } else {
                        singed[0] = true;
                        index[0]++;
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}
