package webservice.springservicepractice.repository

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import webservice.springservicepractice.domain.Member

internal class MemoryMemberRepositoryTest {

    @Autowired
    val repository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repository.clearStore()
    }
    
    @Test
    fun `findById`() {
        //given
        val member = Member(0,"Spring")
        //when
        repository.save(member)

        val result = repository.findById(member.id)
        println(result == member)

        assertThat(result).isEqualTo(member)
        //then 
    }
    
    @Test
    fun `findByName`() {
        //given
        val member1 = Member(1, "spring1")
        repository.save(member1)

        val member2 = Member(2, "spring2 ")
        repository.save(member2)
        //when
        val result = repository.findByName("spring1")
        //then
        assertThat(result).isEqualTo(member1 )
    }

    @Test
    fun `findAll`() {
        //given
        val member1 = Member(1, "spring1")
        repository.save(member1)

        val member2 = Member(2, "spring2 ")
        repository.save(member2)

        //when
        val result = repository.findALl()
        //then
        assertThat(result.size).isEqualTo(2)
    }

}