package cn.jely.cd;

import cn.jely.cd.domain.DemoDomain;
import cn.jely.cd.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.security.InvalidParameterException;

@Controller
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "/controller.do", method = RequestMethod.GET)
    public void controller(HttpServletResponse response, Integer id) throws Exception {
        switch(id) {
            case 1:
                throw new BusinessException("10", "controller10");
            case 2:
                throw new BusinessException("20", "controller20");
            case 3:
                throw new BusinessException("30", "controller30");
            case 4:
                throw new BusinessException("40", "controller40");
            case 5:
                throw new BusinessException("50", "controller50");
            default:
                throw new InvalidParameterException("Controller Parameter Error");
        }
    }

    @RequestMapping(value = "/service.do", method = RequestMethod.GET)
    public void service(HttpServletResponse response, Integer id) throws Exception {
        demoService.exception(id);
    }

    @RequestMapping(value = "/dao.do", method = RequestMethod.GET)
    public void dao(HttpServletResponse response, Integer id) throws Exception {
        demoService.daoexp(id);
    }

    @RequestMapping(value = "/ajax")
    @ResponseBody
    public DemoDomain xml() {
        DemoDomain demoDomain = new DemoDomain();
        demoDomain.preSave();
        return demoDomain;
    }
}
