package com.learncamel.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Country {
    protected String sISOCode;
    protected String sName;
}
