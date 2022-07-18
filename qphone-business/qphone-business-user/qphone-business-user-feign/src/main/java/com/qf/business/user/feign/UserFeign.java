package com.qf.business.user.feign;

import com.qf.data.base.r.R;
import com.qf.data.user.entity.User;
import com.qf.data.user.vo.input.WxUserInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qiu16
 */
@FeignClient("user-server")
public interface UserFeign {
    @PostMapping("user/wx/query")
    R<User> wxUserQuery(WxUserInput wxUserInput);
}
