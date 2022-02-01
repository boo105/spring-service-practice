package webservice.springservicepractice.repository

import org.springframework.stereotype.Repository
import webservice.springservicepractice.domain.Member

@Repository
class MemoryMemberRepository(
    // 실무에서는 동시성 문제때문에 공유되는 변수 일때는 concurrenthashmap을 쓴다고 한다.
    private val store: HashMap<Long, Member> = HashMap<Long, Member>(),
    private var sequence : Long = 0L    // sequence는 키값 생성을 위한거임 ex) 0, 1, 2 ...
) : MemberRepository {

    override fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member   // store.put(member.id, member) 랑 똑같음
        return member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }

    override fun findByName(name: String): Member? {
        return store.values
            .filter { it.name == name }
            .firstOrNull()
    }

    override fun findALl(): List<Member> {
        return store.values.toList()
    }

    fun clearStore() = store.clear()
}