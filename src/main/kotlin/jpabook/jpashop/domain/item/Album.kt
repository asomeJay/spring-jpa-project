package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Album(
    override var name: String,
    override var price: Int,
    override var stockQuantity: Int,
    val artist: String,
    val etc: String):
    Item(name=name, price=price, stockQuantity = stockQuantity)