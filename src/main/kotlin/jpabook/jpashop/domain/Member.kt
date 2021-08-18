package jpabook.jpashop.domain

import javax.persistence.*

@Entity
class Member(
    @Id @GeneratedValue
    @Column(name = "member_id")
    var id: Long? = null,
    val name: String,
    @Embedded
    val address: Address,

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    val orders: List<Order> = mutableListOf()
)