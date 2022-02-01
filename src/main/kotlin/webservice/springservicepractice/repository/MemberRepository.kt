package webservice.springservicepractice.repository

import webservice.springservicepractice.domain.Member

interface MemberRepository {

    fun save(member: Member) : Member

    fun findById(id : Long) : Member?

    fun findByName(name : String) : Member?

    fun findALl() : List<Member>
}