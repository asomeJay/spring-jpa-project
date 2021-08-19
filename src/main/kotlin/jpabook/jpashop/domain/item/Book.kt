package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Book(
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val author: String,
    val isbn: String):
    Item(name=name, price=price, stockQuantity=stockQuantity)