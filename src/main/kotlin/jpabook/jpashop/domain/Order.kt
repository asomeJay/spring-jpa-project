package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Id @GeneratedValue
    @Column(name = "order_id")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val orderItems: MutableList<OrderItem> = mutableListOf(),

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    val delivery: Delivery,

    val orderDate: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    private var status: OrderStatus,
) {
    // 생성 메서드
    companion object {
        fun createOrder(member: Member, delivery: Delivery, vararg orderItems: OrderItem): Order {
            val order = Order(member = member, delivery = delivery, status = OrderStatus.ORDER)
            orderItems.forEach { orderItem -> order.orderItems.add(orderItem) }

            return order
        }
    }

    // 비지니스 로직
    fun cancel() {
        if (delivery.status == DeliveryStatus.COMP) throw IllegalStateException("이미 배송중이라 취소할 수 없습니다.")

        this.status = OrderStatus.CANCEL
        orderItems.forEach { it.cancel() }
    }

    //==조회 로직==//
    fun getTotalPrice(): Int = orderItems.sumOf { it.getTotalPrice() }

}