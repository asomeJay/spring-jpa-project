package jpabook.jpashop.controller


class MemberForm(
    val name: String,
    val city: String,
    val street: String,
    val zipcode: String,
) {
    constructor() : this(name = "", city = "", street = "", zipcode = "")
}