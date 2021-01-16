package cloud.provider.payment8000.service;

import cloud.api.common.entities.Payment;
import cloud.provider.payment8000.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/9/10
 */
@Service
public class PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);
    }

}
