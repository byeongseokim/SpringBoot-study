package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    public MemberService() {

    }

    /**
     * 회원가입
     */
    public Long join(Member member){

        long start = System.currentTimeMillis();

        try {
            //같은 이름이 있는 중복 회원 X
            validateDuplicateMember(member); //중복 회원 검증

            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {;
        /*Optional<Member> result = memberRepository.findByName((member.getName()));
        result.ifPresent(m -> {*/
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        long start = System.currentTimeMillis();

        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }

    }

    public  Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

