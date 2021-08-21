package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Book(
    override var name: String,
    override var price: Int,
    override var stockQuantity: Int,
    val author: String,
    val isbn: String):
    Item(name=name, price=price, stockQuantity=stockQuantity)