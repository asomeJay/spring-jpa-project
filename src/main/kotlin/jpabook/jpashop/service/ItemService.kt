package jpabook.jpashop.service

import jpabook.jpashop.domain.Item
import jpabook.jpashop.repository.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ItemService (
    val itemRepository: ItemRepository)
{
    fun saveItem(item:Item) = itemRepository.save(item)

    fun findItems():List<Item> = itemRepository.findAll()

    fun findOne(itemId:Long):Item = itemRepository.findOne(itemId)
}