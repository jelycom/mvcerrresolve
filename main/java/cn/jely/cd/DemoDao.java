package cn.jely.cd;

import cn.jely.cd.exception.BusinessException;
import org.springframework.stereotype.Repository;

import java.security.InvalidParameterException;

@Repository
public class DemoDao {
    public void exception(int expId) {
        switch (expId) {
            case 1:
                throw new BusinessException("1", "dao1");
            case 2:
                throw new BusinessException("2", "dao2");
            case 3:
                throw new BusinessException("3", "dao3");
            default:
                throw new InvalidParameterException("Invalid Dao Parameter");
        }
    }
}
