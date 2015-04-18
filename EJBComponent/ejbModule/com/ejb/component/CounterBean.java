package com.ejb.component;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CounterBean
 */
@Stateful
@Remote(CounterBeanRemote.class)
public class CounterBean implements CounterBeanRemote {

	private int count = 0;
	 
    @Override
    public void increment() {
        this.count++;
    }
 
    @Override
    public void decrement() {
        this.count--;
    }
 
    @Override
    public int getCount() {
        return this.count;
    }

}
