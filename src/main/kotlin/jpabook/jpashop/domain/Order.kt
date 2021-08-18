package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Id @GeneratedValue
    @Column(name = "order_id")
    var id: Long?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    val orderItems: List<OrderItem> = arrayListOf(),

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    val delivery: Delivery,

    val orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    val status: OrderStatus,
)
