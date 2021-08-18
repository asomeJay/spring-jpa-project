package jpabook.jpashop

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberRepositoryTest(@Autowired val memberRepository: MemberRepository) {

    @Test
    @Transactional
    fun testMember() {
        val member: Member = Member("memberA")
        val saveId: Long? = memberRepository.save(member)



    }
}