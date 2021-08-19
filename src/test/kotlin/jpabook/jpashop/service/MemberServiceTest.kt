package jpabook.jpashop.service

import jpabook.jpashop.domain.Address
import jpabook.jpashop.domain.Member
import jpabook.jpashop.repository.MemberRepository
import org.junit.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.fail
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalStateException
import javax.persistence.EntityManager

@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
class MemberServiceTest (){

    @Autowired
    lateinit var memberService: MemberService

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var em:EntityManager

    @Test
     fun 회원가입 (){
        // given
        val member = Member(name="kim", address = Address(city="seoul", street = "mapo", zipcode = "030"))

        // when
        val saveId: Long = memberService.join(member)

        em.flush()

        // then
        assert(member == memberRepository.findOne(saveId))
    }

    @Test(expected = IllegalStateException::class)
    internal fun 중복회원가입 (){
        // given
        val member1 = Member(name="kim", address = Address(city="seoul", street = "mapo", zipcode = "030"))
        val member2 = Member(name="kim", address = Address(city="seoul", street = "mapo", zipcode = "030"))

        // when
        memberService.join(member1)
        memberService.join(member2)

        // then
        fail("중복 검사 실패")
    }
}