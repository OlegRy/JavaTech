package edu.kfu.itis.spring.day02.lab04;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface QuoterQualifier {
    QuoterType value();
}
