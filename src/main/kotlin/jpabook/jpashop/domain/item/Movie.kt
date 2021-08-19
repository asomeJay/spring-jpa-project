package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Movie (
    val name: String,
    val price: Int,
    val stockQuantity: Int,
    val director:String,
    val isbn: String):

    Item(name=name, price=price, stockQuantity = stockQuantity )