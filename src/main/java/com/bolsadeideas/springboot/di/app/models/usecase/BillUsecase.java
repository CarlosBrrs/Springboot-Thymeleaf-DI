package com.bolsadeideas.springboot.di.app.models.usecase;

import com.bolsadeideas.springboot.di.app.models.domain.Bill;
import com.bolsadeideas.springboot.di.app.models.domain.BillItem;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;

public class BillUsecase {

    //@Autowired
    private Bill bill;

    public BillUsecase(Bill bill) {
        this.bill=bill;
    }

    public Bill totalBill(Bill bill) {
        int total = 0;
        for (BillItem item: bill.getItems()) {
            total = total + (item.getProduct().getPrice()*item.getQuantity());
        }
        bill.setTotal(total);
        return bill;
    }
}
