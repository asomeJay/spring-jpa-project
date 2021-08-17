package jpabook.jpashop.domain

import javax.persistence.Embeddable

@Embeddable
class Address (
    city:String,
    street: String,
    zipcode:String
)
