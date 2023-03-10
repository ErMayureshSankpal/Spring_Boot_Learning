package com.example.company.serializers;

import com.example.company.model.Countries;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.OutputStream;

public class CustomSerializer implements Serializer<Countries> {
    @Override
    public void serialize(Countries object, OutputStream outputStream) throws IOException {
        
    }
}
