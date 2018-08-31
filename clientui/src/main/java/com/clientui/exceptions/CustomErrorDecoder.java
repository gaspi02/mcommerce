package com.clientui.exceptions;


import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaulrErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        if(response.status() == 404){

            return new ProductNotFoundException("Produit non trouvé");
        }
        return defaulrErrorDecoder.decode(methodKey, response);
    }
}
