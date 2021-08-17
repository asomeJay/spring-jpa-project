package jpabook.jpashop.domain

import javax.persistence.*

@Entity
class OrderItem(
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "item_id")
    val item: Item,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: Order,

    val orderPrice: Int,
    val count: Int
)
