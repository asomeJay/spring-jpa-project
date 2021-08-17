package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Album(
    override val name: String,
    override val price: Int,
    override val stockQuantity: Int,
    val artist: String,
    val etc: String):
    Item(name=name, price=price, stockQuantity = stockQuantity)