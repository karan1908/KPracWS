package com.ejb.component;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AdderImpl
 */
@Stateless
@Remote(AdderImplRemote.class)
public class AdderImpl implements AdderImplRemote {
 
    public int add(int a,int b){  
        return a+b;  
    }  

}
