package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Album(
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val artist: String,
    val etc: String):
    Item(name=name, price=price, stockQuantity = stockQuantity)