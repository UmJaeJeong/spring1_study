package hello.core.member;

public class MemberServcieImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServcieImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
