package webservice.springservicepractice.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import webservice.springservicepractice.domain.Member
import webservice.springservicepractice.repository.MemoryMemberRepository
import kotlin.IllegalStateException

internal class MemberServiceTest {

    private val memoryMemberRepository = MemoryMemberRepository()
    private val memberService = MemberService(memoryMemberRepository)

    // 실제로는 메소드 단위로 실행하기 때문에 테스트 끼리의 전혀 영향을 받지않음
    // 따라서 afterEach는 이런상황일때 안적어도 될듯?
    @AfterEach
    fun afterEach() {
        println(memoryMemberRepository.findALl())
        // memoryMemberRepository.clearStore()
    }

    @Test
    fun 회원가입() {
        //given
        val member = Member(0, "spring")

        //when
        val saveId = memberService.join(member)

        //then
        val findMember = memberService.findOne(member.id)
        assertThat(member.name).isEqualTo(findMember?.name)
    }
    
    @Test
    fun 중복_회원_예외() {
        //given
        val member1 = Member(0, "spring2")
        val member2 = Member(0, "spring2")

        //when
        memberService.join(member1)
        val e = assertThrows(IllegalStateException::class.java) { memberService.join(member2) }
        assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.")

//        try {
//            memberService.join(member2)
//            fail()
//        }
//        catch (e : IllegalStateException) {
//            assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.")
//        }
        //then

    }

    @Test
    fun findMembers() {
        //given

        //when

        //then
    }

    @Test
    fun findOne() {
        //given

        //when

        //then
    }
}