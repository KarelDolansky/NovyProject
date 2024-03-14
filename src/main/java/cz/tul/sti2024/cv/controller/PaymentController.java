package cz.tul.sti2024.cv.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.tul.sti2024.cv.model.Payment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;


@RestController
public class PaymentController {
    @RequestMapping("/")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/time")
    public String getTime() {
        return new Date(System.currentTimeMillis()).toString();
    }

    private Payment paymentValue(String payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(payload, Payment.class);
    }


    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String paymentProcessing(String payload){
        Payment payment;
        try
        {
            payment=paymentValue(payload);
        }catch (JsonProcessingException ex) {
            ex.printStackTrace();
            return "Payment processing failed!";
        }
        String toPay = payment.getAmount() + "/" + payment.getCurrency();
        pay(toPay);
        return "Payment processed successfully!";
    }

    private void pay(String payment){
        //idk co ma robit
        System.out.println(payment);
    }
}

