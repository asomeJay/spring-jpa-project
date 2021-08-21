package jpabook.jpashop.service

import jpabook.jpashop.domain.*
import jpabook.jpashop.repository.ItemRepository
import jpabook.jpashop.repository.MemberRepository
import jpabook.jpashop.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderService(
    private val orderRepository: OrderRepository,
    private val memberRepository: MemberRepository,
    private val itemRepository: ItemRepository,
) {
    // 주문
    @Transactional
    fun order(memberId: Long, itemId: Long, count: Int): Long {
        val member: Member = memberRepository.findOne(memberId)
        val item: Item = itemRepository.findOne(itemId)

        val orderItem: OrderItem = OrderItem.createItem(item, item.price, count)
        val delivery = Delivery(address = member.address, status = DeliveryStatus.COMP)
        val order: Order = Order.createOrder(member, delivery, orderItem)

        orderRepository.save(order)
        return order.id!!
    }
    // 취소

    @Transactional
    fun cancelOrder(orderId:Long) {
        orderRepository.findOne(orderId).cancel()
    }
    // 검색


}