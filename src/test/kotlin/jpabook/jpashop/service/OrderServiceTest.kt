package jpabook.jpashop.service

import jpabook.jpashop.domain.Address
import jpabook.jpashop.domain.Member
import jpabook.jpashop.domain.Order
import jpabook.jpashop.domain.OrderStatus
import jpabook.jpashop.domain.item.Book
import jpabook.jpashop.repository.OrderRepository
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
internal class OrderServiceTest(
    val em:EntityManager,
    val orderService: OrderService,
    val orderRepository: OrderRepository
) {


    @Test
    internal fun 상품주문(){
        // given
        val member:Member = Member(name="사람", address = Address(city = "서울", street = "마포구", zipcode = "aa"))
        em.persist(member)

        val book:Book = Book(name="book", price=10000, stockQuantity = 10, author = "aa", isbn = "aa")
        em.persist(book)

        var orderCount = 2
        // when
        val orderId: Long = orderService.order(member.id!!, book.id!!, orderCount)

        // then
        val findOne: Order = orderRepository.findOne(orderId)

        assertEquals(OrderStatus.ORDER, findOne.status, "상품 주문시 상태는 ORDER")
        assertEquals(1, findOne.orderItems.size, "주문한 상품 종류수가 정확해야한다. ")
        assertEquals(10000 * orderCount, findOne.getTotalPrice(), "주문 가격은 가격 * 수량이다")

    }

    @Test
    internal fun 주문취소 (){
        // given

        // when

        // then
    }

    @Test
    internal fun 상품주문_재고수량초과(){
        // given

        // when

        // then
    }
}