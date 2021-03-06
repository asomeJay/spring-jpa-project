package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Item
import javax.persistence.Entity

@Entity
class Movie (
    override var name: String,
    override var price: Int,
    override var stockQuantity: Int,
    val director:String,
    val isbn: String):

    Item(name=name, price=price, stockQuantity = stockQuantity )