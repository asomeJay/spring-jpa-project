package jpabook.jpashop.domain

import javax.persistence.*

@Entity
class Delivery(
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    var id: Long? = null,

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    val order: Order,

    @Embedded
    val address: Address,

    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus
)
