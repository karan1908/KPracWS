/**
 * SoapServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ibm.soap.server;

public interface SoapServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSoapServiceAddress();

    public com.ibm.soap.server.SoapService getSoapService() throws javax.xml.rpc.ServiceException;

    public com.ibm.soap.server.SoapService getSoapService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
