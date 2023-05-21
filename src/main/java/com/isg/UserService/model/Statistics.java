package com.isg.UserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    private String label;
    private Object value;

    public static double getSum(List<OrderDetail> details) {
        double sum = 0;
        for (int i = 0; i < details.size(); i++) {
            sum += details.get(i).getApprovedPrice() * details.get(i).getQuantity();
        }
        return sum;
    }

}
