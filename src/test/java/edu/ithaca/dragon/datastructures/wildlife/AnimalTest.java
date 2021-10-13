package edu.ithaca.dragon.datastructures.wildlife;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.wildlife.Animal;

public class AnimalTest {

    public void pause() throws InterruptedException{
        Thread.sleep(2);
    }

    @Test
    public void testAnimalPriority() throws InterruptedException{
        Animal a1 = new Animal("Jasper", 45, 40);
        Animal a2 = new Animal("Genny", 35, 30);
        Animal a3 = new Animal("Poncho", 4, 6);

        PriorityQueue<Animal> feedingQueue = new PriorityQueue<>();
        feedingQueue.offer(a1);
        feedingQueue.offer(a2);
        feedingQueue.offer(a3);

        assertEquals(a3, feedingQueue.poll());
        a3.eat();
        feedingQueue.offer(a3);
        pause();

        Animal fed2 = feedingQueue.poll();
        assertTrue(fed2==a1 || fed2==a2);
        fed2.eat();
        feedingQueue.offer(fed2);
        pause();

        Animal next = feedingQueue.poll();
        assertTrue(next==a1 || next==a2);
        assertTrue(next != fed2);
        next.eat();
        feedingQueue.offer(next);
        pause();
        
        assertEquals(a3, feedingQueue.poll());
    }
    
}
