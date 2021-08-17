package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Movie (
    override val name: String,
    override val price: Int,
    override val stockQuantity: Int,
    val director:String,
    val isbn: String):

    Item(name=name, price=price, stockQuantity = stockQuantity )