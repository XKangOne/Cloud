package top.yk.coupon.customer.feign;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenfeignSentinelInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        //传递给下游服务的标记
        template.header("SentinelSource", "coupon-customer-serv");
    }
}
