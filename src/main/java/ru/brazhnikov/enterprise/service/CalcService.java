package ru.brazhnikov.enterprise.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class CalcService {

    @WebMethod
    public Integer calc (@WebParam( name = "a") int a, @WebParam( name = "b") int b ) {
        return a + b;
    }

    public static void main(String[] args) {
        Endpoint.publish( "http://localhost:8080/CalcService?wsdl", new CalcService() );
    }
}
