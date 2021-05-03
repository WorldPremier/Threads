package com.tts.week12day1;

public class Deadlock {
    static class Friend{
        private final String name;

        public Friend(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public synchronized void bow(Friend bower){
            System.out.format("%s: %s has bowed to me! %n", this.getName(), bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower){
            System.out.format("%s: %s has bowed to me! %n", this.getName(), bower.getName());
        }
    }

    public static void main(String[] args){
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("gaston");

        new Thread(() -> alphonse.bow(alphonse)).start();
        new Thread(() -> gaston.bow(gaston)).start();
    }
}
