package jpabook.jpashop.domain

import javax.persistence.*

@Entity
class OrderItem(
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    val item: Item,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: Order?,

    val orderPrice: Int,
    val count: Int
)
{
    companion object {
        fun createItem(item:Item, orderPrice:Int, count: Int):OrderItem {
            item.removeStock(count)
            return OrderItem(item=item, orderPrice = orderPrice, count = count, order = null)
        }
    }

    fun cancel() = item.addStock(count)

    fun getTotalPrice():Int = orderPrice * count

}
