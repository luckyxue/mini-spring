package com.minis.test;

import com.minis.web.bind.WebDataBinder;
import com.minis.web.bind.support.WebBindingInitializer;

import java.util.Date;

public class DateInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(Date.class, "yyyy-MM-dd", false));
    }
}
