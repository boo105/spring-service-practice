package webservice.springservicepractice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import webservice.springservicepractice.domain.Member
import webservice.springservicepractice.repository.MemoryMemberRepository

@Service
class MemberService(
    @Autowired
    private val memberRepository: MemoryMemberRepository
) {
    // 회원가입
    fun join(member : Member) : Long {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id
    }

    fun validateDuplicateMember(member: Member) {
        val result = memberRepository.findByName(member.name)
        result?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        }
    }

    // 전체 회원 조회
    fun findMembers() : List<Member> = memberRepository.findALl()

    fun findOne(memberId : Long) : Member? = memberRepository.findById(memberId)
}