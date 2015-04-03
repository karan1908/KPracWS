package com.ibm.core.java;

import java.awt.Toolkit;
import org.jfugue.Pattern;
import org.jfugue.Player;
import org.jfugue.Rhythm;

public class MultipleProducerConsumer {

    static Monitor monitor;

    public MultipleProducerConsumer(int maxSize)
    {
        monitor = new Monitor(maxSize);
        new Producer().start();
        new Producer().start();
        new Consumer().start();
        new Producer().start();
        new Consumer().start();
        new Producer().start();
        new Consumer().start();
    }

    class Producer extends Thread{

        @Override
        public void run() {
            while(true)
            {
                try {
                    monitor.insert();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            while(true)   //infinite
            {
                try {
                    monitor.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     class Monitor {

          int n;
          int maxSize;

         public Monitor(int maxSize)
         {
             n=0;
             this.maxSize = maxSize;
         }

        synchronized void insert() throws InterruptedException 
        {
        	
            if(n==maxSize)
            {
                System.out.println("MAX SIZE 100 REACHED !!!!!!!!!!!!!!!!!!!! "+ n);
                letsPlay();
                Thread.sleep(5000);
            	wait();
            }
            System.out.println("Producer: "+n++);
            Thread.sleep(10);
            if(n==1)
                notifyAll();
        }

        synchronized void remove() throws InterruptedException 
        {
        	
            if(n<=0)
            {
            	System.out.println("N = 0 !!!!!!!!!!!!!!!!!!!! "+n);
            	for(int i=0;i<2;i++)
            	{
            	Toolkit.getDefaultToolkit().beep();
            	Thread.sleep(1000);
            	}
            	Thread.sleep(1000);
            	wait();
            }
            System.out.println("Consumer: "+n--);
            if(n==maxSize-1)
                notifyAll();
        }
    }

    public static void main(String[] args) {
        MultipleProducerConsumer pc = new MultipleProducerConsumer(100);

    }
    
public void letsPlay()
{
	// "Frere Jacques"
	Pattern pattern1 = new Pattern("C5q D5q E5q C5q");

	// "Dormez-vous?"
	Pattern pattern2 = new Pattern("E5q F5q G5h");

	// "Sonnez les matines"
	Pattern pattern3 = new Pattern("G5i A5i G5i F5i E5q C5q");

	// "Ding ding dong"
	Pattern pattern4 = new Pattern("C5q G4q C5h");

	// Put all of the patters together to form the song
	Pattern song = new Pattern();
	song.add(pattern1, 2); // Adds 'pattern1' to 'song' twice
	song.add(pattern2, 2); // Adds 'pattern2' to 'song' twice
	song.add(pattern3, 2); // Adds 'pattern3' to 'song' twice
	song.add(pattern4, 2); // Adds 'pattern4' to 'song' twice

	// Play the song!
	Player player = new Player(); player.play(song);
	
	/*Rhythm rhythm = new Rhythm();
	rhythm.setLayer(1, "O..oO...O..oOO..");
	rhythm.setLayer(2, "..*...*...*...*.");
	rhythm.setLayer(3, "^^^^^^^^^^^^^^^^");
	rhythm.setLayer(4, "...............!");
	rhythm.addSubstitution('O', "[BASS_DRUM]i");
	rhythm.addSubstitution('o', "Rs [BASS_DRUM]s");
	rhythm.addSubstitution('*', "[ACOUSTIC_SNARE]i");
	rhythm.addSubstitution('^', "[PEDAL_HI_HAT]s Rs");
	rhythm.addSubstitution('!', "[CRASH_CYMBAL_1]s Rs");
	rhythm.addSubstitution('.', "Ri");
	Pattern pattern = rhythm.getPattern();
	pattern.repeat(4);
	Player player = new Player();
	player.play(pattern);*/

}
    
}