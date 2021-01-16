package mybatis.simple.service;

import mybatis.simple.mapper.SysAccountMapper;
import mybatis.simple.pojo.SysAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author windeaker
 * @Description TODO
 * @Date 20/10/26
 */
@Service
public class AccountService {
    @Resource
    SysAccountMapper accountMapper;

    @Transactional(rollbackFor = {SQLException.class})
    public void insertAccountByTransaction() {
        Date date = new Date();
        SysAccount account = new SysAccount();
        account.setAccount("123");
        account.setCstCreated(date);
        account.setCstModified(date);
        account.setDeleted((byte) 0);
        account.setDigestSalt("123");
        account.setPwdDigest("123");
        account.setNickName("123");
        accountMapper.insert(account);
        SysAccount account2 = new SysAccount();
        BeanUtils.copyProperties(account,account2);
        account2.setPwdDigest(null);
        accountMapper.insert(account2);
    }

    public void insertAccount() {
        Date date = new Date();
        SysAccount account = new SysAccount();
        account.setAccount("123");
        account.setCstCreated(date);
        account.setCstModified(date);
        account.setDeleted((byte) 0);
        account.setDigestSalt("123");
        account.setPwdDigest("123");
        account.setNickName("123");
        accountMapper.insert(account);
        SysAccount account2 = new SysAccount();
        BeanUtils.copyProperties(account,account2);
        account2.setPwdDigest(null);
        accountMapper.insert(account2);
    }
}
