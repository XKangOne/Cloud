package org.example.coupon.customer.loadbalance;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

/** * @author mqxu *
 * @date 2023/9/17 *
 * @description 金丝雀测试规则，可以将这个负载均衡策略单独拎出来，作为一个公共组件提供服务
 *  **/
@Slf4j
public class CanaryRule implements ReactorServiceInstanceLoadBalancer {
    private final ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;
    private final String serviceId;

    public CanaryRule(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId) {
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
        this.serviceId = serviceId;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        return null;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose() {
        return ReactorServiceInstanceLoadBalancer.super.choose();
    }
}
