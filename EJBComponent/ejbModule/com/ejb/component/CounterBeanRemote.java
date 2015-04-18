package com.ejb.component;

import javax.ejb.Remote;

public interface CounterBeanRemote {
	
	void increment();
	 
    void decrement();
 
    int getCount();

}
