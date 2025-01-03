package i.vk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import i.vk.entity.OrderDetails;

public interface OrderRepo extends JpaRepository<OrderDetails, String> {

}
