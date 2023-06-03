package cart.dto;

import cart.domain.Coupon;
import cart.domain.Order;
import java.util.List;
import java.util.Objects;

public class OrderDetailResponse {

    private Long orderId;
    private List<OrderItemResponse> products;
    private Long totalPrice;
    private Long totalPayments;
    private Long deliveryFee;
    private CouponResponse coupon;

    public OrderDetailResponse() {
    }

    public OrderDetailResponse(final Long orderId,
                               final List<OrderItemResponse> products,
                               final Long totalPrice,
                               final Long totalPayments,
                               final Long deliveryFee,
                               final CouponResponse coupon) {
        this.orderId = orderId;
        this.products = products;
        this.totalPrice = totalPrice;
        this.totalPayments = totalPayments;
        this.deliveryFee = deliveryFee;
        this.coupon = coupon;
    }

    public static OrderDetailResponse from(final Order order) {
        final Coupon coupon = order.getCoupon();
        if (Objects.nonNull(coupon)) {
            return new OrderDetailResponse(
                    order.getId(),
                    OrderItemResponse.from(order.getOrderItems()),
                    order.totalProductPrice().getValue(),
                    order.totalPayments().getValue(),
                    order.getDeliveryFee().getValue(),
                    CouponResponse.from(coupon)
            );
        }
        return new OrderDetailResponse(
                order.getId(),
                OrderItemResponse.from(order.getOrderItems()),
                order.totalProductPrice().getValue(),
                order.totalPayments().getValue(),
                order.getDeliveryFee().getValue(),
                null
        );
    }

    public Long getOrderId() {
        return orderId;
    }

    public List<OrderItemResponse> getProducts() {
        return products;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Long getTotalPayments() {
        return totalPayments;
    }

    public Long getDeliveryFee() {
        return deliveryFee;
    }

    public CouponResponse getCoupon() {
        return coupon;
    }
}
