package com.example.client1.Utils;


import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date formatting  yyyy-MM-dd HH:mm:ss
 */
@Component
public class TimeTransfer {

    public String transfer(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        return time;
    }
}
