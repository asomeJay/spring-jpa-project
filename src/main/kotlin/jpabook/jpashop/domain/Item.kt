package jpabook.jpashop.domain

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
class Item(
    @Id @GeneratedValue
    @Column(name = "item_id")
    var id: Long? = null,
    private var name: String,
    private var price: Int,
    private var stockQuantity: Int,

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    val categories: List<Category> = mutableListOf(),


    ) {
    fun addStock(quantity: Int): Unit {
        this.stockQuantity += quantity
    }

    fun removeStock(quantity: Int) {
        val restStock: Int = this.stockQuantity - quantity
        if (restStock < 0) throw NotEnoughStockException("need more stock")

        this.stockQuantity = restStock
    }
}

