package jpabook.jpashop.domain

import javax.annotation.processing.Generated
import javax.persistence.*

@Entity
class Category(
    @Id @GeneratedValue
    var id: Long? = null,
    val name: String,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "category_item",
        joinColumns = arrayOf(JoinColumn(name="category_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "item_id")))
    val items: List<Item> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    val parentCategory: Category,

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    val childCategory: List<Category> = mutableListOf()
)