package jpabook.jpashop.domain

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
class Item(
    @Id @GeneratedValue
    @Column(name = "item_id")
    val id: Long? = null,
    val name: String,
    val price: Int,
    val stockQuantity: Int,

    @ManyToMany(mappedBy = "items")
    val categories: List<Category> = mutableListOf()
)
