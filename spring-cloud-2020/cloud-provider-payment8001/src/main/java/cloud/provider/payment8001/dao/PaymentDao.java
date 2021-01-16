package cloud.provider.payment8001.dao;

import cloud.api.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/9
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
