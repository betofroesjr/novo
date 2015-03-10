package com.controle.auditoria;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.model.entidades.base.Foo;

public class MyExclusionStrategy implements ExclusionStrategy {
   
	private final Class<?> typeToSkip;

    MyExclusionStrategy(Class<?> typeToSkip) {
      this.typeToSkip = typeToSkip;
    }

    public boolean shouldSkipClass(Class<?> clazz) {
      return (clazz == typeToSkip);
    }

    public boolean shouldSkipField(FieldAttributes f) {
      return f.getAnnotation(Foo.class) != null;
    }
  }
