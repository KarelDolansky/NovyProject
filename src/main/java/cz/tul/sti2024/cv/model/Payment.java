package cz.tul.sti2024.cv.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Payment {
    private float amount;
    private String currency;
    private Date date;
    private String paymentType;
    private List<String> items;
}
