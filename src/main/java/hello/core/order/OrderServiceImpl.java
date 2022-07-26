package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveRepositoriesAutoConfiguration;

public class OrderServiceImple implements OrderService {

    MemberRepository memberRepository ;
    DiscountPolicy discountPolicy;

    public OrderServiceImple(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository= memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(findMember, itemPrice);

        Order order = new Order(memberId, itemName, itemPrice, discount);
        return order;
    }
}
