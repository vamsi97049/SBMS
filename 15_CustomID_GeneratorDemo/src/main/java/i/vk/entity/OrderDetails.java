package i.vk.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;  // Use this import for GenericGenerator

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue(generator = "order-id-generator")
    @GenericGenerator(name = "order-id-generator", strategy = "i.vk.util.OrderIdGenerator")
    private String orderId;

    private String orderName;
    private Date orderOn;
}
