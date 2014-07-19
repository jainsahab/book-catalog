package com.prateekj.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.stereotype.Component;

@Component
public class CustomObjectMapper extends ObjectMapper{

  public CustomObjectMapper() {
    registerModule(new Hibernate4Module());
  }

}
