package com.ejb.component;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(IncrementerBeanRemote.class)
public class IncrementerBean implements IncrementerBeanRemote {
	
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
