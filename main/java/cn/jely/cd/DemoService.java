package cn.jely.cd;

import cn.jely.cd.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.InvalidParameterException;

@Service
public class DemoService {
    @Resource
    private DemoDao demoDao;

    public void exception(int expId) {
        switch (expId) {
            case 1:
                throw new BusinessException("1", "service1");
            case 2:
                throw new BusinessException("2", "service2");
            case 3:
                throw new BusinessException("3", "service3");
            default:
                throw new InvalidParameterException("Invalid Service Parameter");
        }
    }

    public void daoexp(int expId) {
        demoDao.exception(expId);
    }
}
